package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
    private static final Database instance = new Database();
    private EntityManagerFactory entityManagerFactory;

    private Database() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
