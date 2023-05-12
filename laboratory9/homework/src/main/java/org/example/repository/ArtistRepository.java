package org.example.repository;

import org.example.entities.Artist;


import javax.persistence.*;

public class ArtistRepository extends AbstractRepository<Artist> {

    public ArtistRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

//    public static void create(Artist artist) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            entityManager.persist(artist);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//            throw new RuntimeException("Failed to create artist: " + e.getMessage(), e);
//        }
//    }
//    public Artist findById(int id) {
//        EntityManager em = EntityManagerFactorySingleton.getEntityManager();
//        try {
//            return em.find(Artist.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public Artist findByName(String name) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        try {
//            TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
//            query.setParameter("name", "%" + name + "%");
//            return query.getSingleResult();
//        } finally {
//            em.close();
//        }
//    }


}
