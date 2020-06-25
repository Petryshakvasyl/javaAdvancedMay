package ua.lviv.lgs.pv.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateUnit");

    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }
}
