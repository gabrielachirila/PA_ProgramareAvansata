package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO implements GenericDAO<Album> {

    private Connection con;

    public AlbumDAO() throws SQLException {
        con = Database.getConnection();
    }
    @Override
    public void create(Album album) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO albums (release_year, title, artist, genre) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, album.getReleaseYear());
            pstmt.setString(2, album.getTitle());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getGenres());
            pstmt.executeUpdate();
            updateId(album);
        }
    }

    private void updateId (Album album) throws SQLException {
        Album album1 = new Album();
        album1 = findByName(album.getTitle());
        album.setId(album1.getId());
    }

    @Override
    public List<Album> findAll() {
        List<Album> albums = new ArrayList<>();
        try (
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM albums")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int releaseYear = resultSet.getInt("release_year");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                String genre = resultSet.getString("genre");
                Album album = new Album();
                album = findByName(title);
                albums.add(album);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving albums: " + e.getMessage());
        }
        return albums;
    }

    @Override
    public Album findByName(String title) {
        String query = "SELECT * FROM albums WHERE LOWER(title) LIKE LOWER(?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, title);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int releaseYear = resultSet.getInt("release_year");
                    String artist = resultSet.getString("artist");
                    String genre = resultSet.getString("genre");
                    String title1 = resultSet.getString("title");

                    Album album = new Album(releaseYear, title1, artist, genre);
                    album.setId(id);
                    return album;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get album by name", e);
        }
    }
    @Override
    public Album findById(int id) {
        String query = "SELECT * FROM albums WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int releaseYear = resultSet.getInt("release_year");
                    String title = resultSet.getString("title");
                    String artist = resultSet.getString("artist");
                    String genre = resultSet.getString("genre");

                    Album album = new Album(releaseYear, title, artist, genre);
                    album.setId(id);
                    return album;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting album by id", e);
        }
    }
}
