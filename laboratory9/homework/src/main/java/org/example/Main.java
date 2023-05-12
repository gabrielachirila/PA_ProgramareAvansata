package org.example;
import org.example.entities.Album;
import org.example.entities.Artist;
import org.example.entities.Genre;
import org.example.repository.ArtistRepository;
import org.example.repository.GenreRepository;
import org.example.repository.AlbumRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        Artist artist1 = new Artist("Adele");
        em.persist(artist);
        em.persist(artist1);

        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();

        a.setName("The Beatles");

        Artist artist3 = new Artist("Michael Jackson");
        ArtistRepository artistRepository = new ArtistRepository(emf);
        artistRepository.create(artist3);


        Genre genre1 = new Genre("Rock");
        Genre genre2 = new Genre("Funk");
        Genre genre3 = new Genre("Soul");
        Genre genre4 = new Genre("Pop");


        GenreRepository genreRepository = new GenreRepository(emf);
        genreRepository.create(genre1);
        genreRepository.create(genre2);
        genreRepository.create(genre3);
        genreRepository.create(genre4);

        System.out.println("Artist gasit: ");
        Artist foundArtist = artistRepository.findByName("Adele", Artist.class);
        System.out.println(foundArtist);


        System.out.println("Toti artistii: ");
        List<Artist> allArtists = artistRepository.findAll(Artist.class);
        for (Artist b : allArtists) {
            System.out.println(a);
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void main(String[] args) {
          testJPA();
    }
}
