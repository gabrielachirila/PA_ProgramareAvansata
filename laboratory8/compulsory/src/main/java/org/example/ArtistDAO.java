package org.example;

import java.sql.*;

public class ArtistDAO {

    private Connection con;

    public ArtistDAO() {
        con = Database.getConnection();
    }

    public void create(String name) throws SQLException {

        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public void print() {
        try {
            String sql = "SELECT * FROM artists";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("Artist's id: " + id + ", name: " + name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM artists WHERE name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM artists WHERE id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
