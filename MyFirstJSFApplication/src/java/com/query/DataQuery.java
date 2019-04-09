/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.eintity.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maxim
 */
public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public DataQuery() {
        emf = Persistence.createEntityManagerFactory("MyFirstJSFApplicationPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean loginControl(String username, String password)
    {
        try{
            Login l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            return l != null;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
}
