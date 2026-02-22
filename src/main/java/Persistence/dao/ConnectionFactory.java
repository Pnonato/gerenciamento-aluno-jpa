package Persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("students");

    public static EntityManager getEntityManager() {

        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
