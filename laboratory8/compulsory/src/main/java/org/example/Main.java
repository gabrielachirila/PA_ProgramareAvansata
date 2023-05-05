package org.example;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {

            var artists = new ArtistDAO();
            var genres = new GenreDAO();
            var albums = new AlbumDAO();

            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");

            albums.create(1979, "The Wall", "Pink Floyd", "Rock");

            albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");

            albums.print();
            artists.print();
            genres.print();

            Database.getConnection().commit();
            Database.closeConnection();

        } catch (SQLException e) {
            System.err.println(e);
            try {
                Database.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
