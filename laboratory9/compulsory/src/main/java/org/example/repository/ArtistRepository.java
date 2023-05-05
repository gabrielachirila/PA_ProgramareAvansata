package org.example.repository;

import org.example.entities.Artist;


import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ArtistRepository {

    private static EntityManagerFactory entityManagerFactory;

    private static ArtistRepository instance;

    private ArtistRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    }

    public static ArtistRepository getInstance() {
        if (instance == null) {
            instance = new ArtistRepository();
        }
        return instance;
    }

    public Artist create(Artist artist) throws SQLException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
        updateId(artist);
        return artist;
    }

    private void updateId (Artist artist) throws SQLException {
        Artist artist1 = new Artist();
        artist1 = findByName(artist.getName());
        artist.setId(artist1.getId());
    }

    public Artist findById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Artist artist = entityManager.find(Artist.class, id);
        artist.setId(id);
        entityManager.close();
        if (artist == null) {
            throw new EntityNotFoundException("Cannot find artist with ID: " + id);
        }
        return artist;
    }

    public Artist findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
//        query.setParameter("name", "%" + name + "%");
//        query.getSingleResult().getId();
        Artist artist;
        try {
            artist = query.getSingleResult();
            artist.setId(query.getSingleResult().getId());
        } catch (NoResultException e) {
            artist = null;
        }
        entityManager.close();
        return artist;
    }

}
