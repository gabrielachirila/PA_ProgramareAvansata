package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements GenericDAO<Genre> {

    private Connection con;

    public GenreDAO() throws SQLException {
        con = Database.getConnection();
    }
    @Override
    public void create(Genre genre) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
            updateId(genre);
        }
    }
    private void updateId (Genre genre) throws SQLException {
        Genre genre1 = new Genre();
        genre1 = findByName(genre.getName());
        genre.setId(genre1.getId());
    }
    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        try (
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM genres")) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Genre genre = new Genre();
                genre = findByName(name);
                genres.add(genre);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving genres: " + e.getMessage());
        }
        return genres;
    }
    @Override
    public Genre findByName(String name)  {
        String query = "SELECT * FROM genres WHERE LOWER(name) LIKE LOWER(?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name1 = resultSet.getString("name");
                    Genre genre = new Genre(name1);
                    genre.setId(id);
                    return genre;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get genre by name", e);
        }
    }
    @Override
    public Genre findById(int id) {
        String query = "SELECT * FROM genres WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Genre genre = new Genre(name);
                    genre.setId(id);
                    return genre;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get genre by id", e);
        }
    }
}
