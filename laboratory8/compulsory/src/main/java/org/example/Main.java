package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        var artists = new ArtistDAO();
        var genres = new GenreDAO();
        var albums = new AlbumDAO();

        artists.create("Pink Floyd");
        artists.create("Michael Jackson");

        Database.getConnection().commit();

        genres.create("Rock");
        genres.create("Funk");
        genres.create("Soul");
        genres.create("Pop");

        Database.getConnection().commit();

        albums.create(1979, "The Wall", "Pink Floyd", "Rock");

        albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");

        Database.getConnection().commit();

        albums.print();
        artists.print();
        genres.print();

        Database.closeConnection();

    }
}
