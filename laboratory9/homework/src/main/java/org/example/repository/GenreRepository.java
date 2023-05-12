package org.example.repository;

import org.example.entities.Genre;


import javax.persistence.*;

public class GenreRepository extends AbstractRepository<Genre>{

    public GenreRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

//    public void create(Genre genre) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            entityManager.persist(genre);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//            throw new RuntimeException("Failed to create genre: " + e.getMessage(), e);
//        }
//    }
//    public Genre findById(int id) {
//        EntityManager em = EntityManagerFactorySingleton.getEntityManager();
//        try {
//            return em.find(Genre.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//    public Genre findByName(String name) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        try {
//            TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName", Genre.class);
//            query.setParameter("name", "%" + name + "%");
//            return query.getSingleResult();
//        } finally {
//            em.close();
//        }
//    }


}
