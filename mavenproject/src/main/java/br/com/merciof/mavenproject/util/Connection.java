/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.mavenproject.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JAVA
 */
public class Connection {
 
    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;
    
    private Connection() {
        
    }
    
    public static synchronized EntityManager getEntityManager() throws Exception{
        
        if(entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("escola");
            entityManager = entityManagerFactory.createEntityManager();
        }
        
        return entityManager;
    }
    
    public static void closeCon() throws Exception {
        entityManager.close();
    }
    
}
