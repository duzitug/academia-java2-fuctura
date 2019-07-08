/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author merciof
 */
public class JpaUtil {
    
    private static EntityManagerFactory factory;
    
    static {
        factory = Persistence.createEntityManagerFactory("jpaproject");
    }
    
     public static EntityManager getEntityManager() {
       return factory.createEntityManager();
    }
     
     public static void closeEntityManager() {
       factory.close();
    }  
}
