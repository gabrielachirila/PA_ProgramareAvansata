package org.example.repository;
import org.example.EntityManagerFactorySingleton;
import org.example.entities.Album;
import org.example.entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album> {

    public AlbumRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

//    public void create(Album album) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            entityManager.persist(album);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }
//
////    public Album findById(Integer id) {
////        EntityManager entityManager = entityManagerFactory.createEntityManager();
////        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findById", Album.class);
////        query.setParameter("id", id);
////        List<Album> results = query.getResultList();
////        return results.isEmpty() ? null : results.get(0);
////    }
//
//    public Album findById(Integer id) {
//        EntityManager em = EntityManagerFactorySingleton.getEntityManager();
//        Album album = em.find(Album.class, id);
//        em.close();
//        return album;
//    }
//
//    public List<Album> findByName(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByName", Album.class);
//        query.setParameter("name", "%" + name + "%");
//        List<Album> results = query.getResultList();
//        entityManager.close();
//        return results;
//    }
}

