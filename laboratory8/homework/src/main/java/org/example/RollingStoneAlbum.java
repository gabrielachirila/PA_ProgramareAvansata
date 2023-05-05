package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RollingStoneAlbum {

    private static final String TABLE = "albums";

    private static final String[] CSV_COLUMNS = {"Number", "Year", "Album", "Artist", "Genre", "Subgenre"};
    private List<Album> rollingStoneAlbums = new ArrayList<>();
    private final Connection con;

    public RollingStoneAlbum() throws SQLException {
        con = Database.getConnection();
    }

    public void importAlbums(String csvFilePath) throws SQLException {
            try (PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO " + TABLE + " (release_year, title, artist) " +
                            "VALUES (?, ?, ?)")) {

                CSVReader reader = new CSVReader(new BufferedReader(new FileReader(csvFilePath)));
                String[] line;

                while ((line = reader.readNext()) != null) {
                    if (line[0].equals(CSV_COLUMNS[0])) {
                        continue;
                    }
                    int releaseYear = Integer.parseInt(line[1]);
                    String title = line[2];
                    String artist = line[3];

                    Album album = new Album(releaseYear, title, artist);
                    rollingStoneAlbums.add(album);

                    stmt.setInt(1, releaseYear);
                    stmt.setString(2, title);
                    stmt.setString(3, artist);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                throw e;
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public void printAlbums () {
        System.out.println("Rolling Stone albums:");
        for (Album a : rollingStoneAlbums) {
            System.out.println("Album: " + a.getTitle() +  ", release year: " + a.getReleaseYear() + ", artist: " + a.getArtist());
        }
    }
}
