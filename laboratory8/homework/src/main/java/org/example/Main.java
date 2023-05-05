package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {

            GenericDAO<Album> albumDAO = new AlbumDAO();
            GenericDAO<Genre> genreDAO = new GenreDAO();
            GenericDAO<Artist> artistDAO = new ArtistDAO();

            Artist artist1 = new Artist("Pink Floyd");
            artistDAO.create(artist1);
            Artist artist2 = new Artist("Michael Jackson");
            artistDAO.create(artist2);


            Genre genre1 = new Genre("Rock");
            genreDAO.create(genre1);
            Genre genre2 = new Genre("Funk");
            genreDAO.create(genre2);
            Genre genre3 = new Genre("Soul");
            genreDAO.create(genre3);
            Genre genre4 = new Genre("Pop");
            genreDAO.create(genre4);

            Album album1 = new Album(1979, "The Wall", "Pink Floyd" , "Rock");
            albumDAO.create(album1);
            Album album2 = new Album(1982, "Thriller", "Michael Jackson" , "Funk,Soul,Pop");
            albumDAO.create(album2);

            System.out.println("All albums in the database:");
            List<Album> albums = albumDAO.findAll();
            for (Album a : albums) {
                System.out.println("Album: " + a.getTitle() + ", id: " + a.getId() + ", release year: " + a.getReleaseYear() + ", artist: " + a.getArtist() + ", genres: " + a.getGenres());
            }

            System.out.println("All artists in the database:");
            List<Artist> artists = artistDAO.findAll();
            for (Artist a : artists) {
                System.out.println("Artist: " + a.getName() + ", id: " + a.getId());
            }

            System.out.println("All genres in the database:");
            List<Genre> genres = genreDAO.findAll();
            for (Genre a : genres) {
                System.out.println("Genre: " + a.getName() + ", id: " + a.getId());
            }

            // using findById and findByName
            Album findAlbum = new Album();

            System.out.println("Album found by id:");
            findAlbum = albumDAO.findById(2);
            System.out.println("Title: " + findAlbum.getTitle() + ", id:" + findAlbum.getId());

            System.out.println("Album found by name:");
            findAlbum = albumDAO.findByName("the wall");
            System.out.println("Title: " + findAlbum.getTitle() + ", id:" + findAlbum.getId());

            RollingStoneAlbum importer = new RollingStoneAlbum();
            importer.importAlbums("C:/Users/gaby/OneDrive/Desktop/albumlist.csv");
            //importer.printAlbums();

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
