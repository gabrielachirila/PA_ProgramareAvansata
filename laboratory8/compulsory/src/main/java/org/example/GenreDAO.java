package org.example;

import java.sql.*;

public class GenreDAO {

    private Connection con;

    public GenreDAO() {
        con = Database.getConnection();
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public void print() {
        try {
            String sql = "SELECT * FROM genres";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("Genre's id: " + id + ", name: " + name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM genres WHERE name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM genres WHERE id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
