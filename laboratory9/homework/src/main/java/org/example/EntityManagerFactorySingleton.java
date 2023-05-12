package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory emf;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManager getEntityManager(){
        if (emf == null){
            createEntityManager();
        }

        return emf.createEntityManager();
    }

    private static void createEntityManager(){

        emf = Persistence.createEntityManagerFactory("ExamplePU");

    }

    public static void closeEntityManager(){
        if (emf != null){
            emf.close();
        }
    }
}
