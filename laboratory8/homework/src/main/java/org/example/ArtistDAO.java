package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements GenericDAO<Artist> {
    private final Connection con;

    public ArtistDAO() throws SQLException {
        con = Database.getConnection();
    }

    @Override
    public void create(Artist artist) throws SQLException {

        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
            updateId(artist);
        }
    }
    private void updateId (Artist artist) throws SQLException {
        Artist artist1 = new Artist();
        artist1 = findByName(artist.getName());
//        System.out.println("Artist gasit: " + artist1.getName() + ", id: " + artist1.getId());
        artist.setId(artist1.getId());
//        System.out.println("Artist modificare: " + artist.getName() + ", id: " + artist.getId());
    }
    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        try (
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM artists")) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Artist artist = new Artist();
                artist = findByName(name);
                artists.add(artist);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving artists: " + e.getMessage());
        }
        return artists;
    }

    @Override
    public Artist findByName(String name) {
        String query = "SELECT * FROM artists WHERE LOWER(name) LIKE LOWER(?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name1 = resultSet.getString("name");
                    Artist artist = new Artist(name1);
                    artist.setId(id);
                    return artist;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get artist by name", e);
        }
    }
    @Override
    public Artist findById(int id){
        String query = "SELECT * FROM artists WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Artist artist = new Artist(name);
                    artist.setId(id);
                    return artist;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get artist by id", e);
        }
    }
}
