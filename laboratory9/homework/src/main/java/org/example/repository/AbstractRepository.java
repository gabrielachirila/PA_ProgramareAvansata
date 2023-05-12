package org.example.repository;

import org.example.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<T extends Serializable> {

    protected final EntityManagerFactory entityManagerFactory;
    protected AbstractRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(T entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    protected T findById(Class<T> entityClass, Serializable id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public T findByName(String name, Class<T> entityClass) {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<T> query = em.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
        query.setParameter(1, name);
        List<T> resultList = query.getResultList();
        if(resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }


    public List<T> findAll(Class<T> entityClass) {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<T> query = em.createNamedQuery(entityClass.getSimpleName(), entityClass);
        return query.getResultList();
    }

}
