/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM_Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author El Gato
 */
public class Controller {
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("IPS-javaPU");
    protected static final EntityManager em = emf.createEntityManager();
    
    public void save(){
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(this);
        em.flush();
        trans.commit();
    }
}
