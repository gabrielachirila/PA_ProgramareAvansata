package org.example;

import java.sql.*;

public class AlbumDAO {

    private Connection con;

    public AlbumDAO() {
        con = Database.getConnection();
    }
    public void create(int year, String title, String artist, String genre) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO albums (release_year, title, artist, genre) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }

    public void print() {
        try {
        String sql = "SELECT * FROM albums";

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int release_year = resultSet.getInt("release_year");
            String title = resultSet.getString("title");
            String artist = resultSet.getString("artist");
            String genre = resultSet.getString("genre");

            System.out.println("Album's id: " + id + ", release year: " + release_year + ", title: " + title + ", artist: " + artist + ", genre: " + genre);
        }
        resultSet.close();
        statement.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public Integer findByName(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM albums WHERE title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT title FROM albums WHERE id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
