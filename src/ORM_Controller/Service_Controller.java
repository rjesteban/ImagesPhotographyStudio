/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM_Controller;
import ORM.Booking;
import java.util.Collection;
import javax.persistence.TypedQuery;
import ORM.Service;
import static ORM_Controller.Controller.em;
import java.util.ArrayList;

/**
 *
 * @author El Gato
 */
public class Service_Controller extends Controller{
    
    //-----------------------read--------------------------------
    public Collection<Service> viewAllServices(){
        TypedQuery<Service> query =
        em.createNamedQuery("Service.findAll", Service.class);
        Collection<Service> results = query.getResultList();
        return results;
    }
    
    public Collection<Service> viewByBId(){
        TypedQuery<Service> query =
        em.createNamedQuery("Service.findByBId", Service.class);
        Collection<Service> results = query.getResultList();
        return results;
    }
    
    public Service findService(Integer key){
        Service s = em.find(Service.class, key);
        return s;
    }
    
    public Collection<Service> viewDistinctServices(){
        TypedQuery<Service> query = 
        em.createNamedQuery("Service.findDistinctServices", Service.class);
        Collection<Service> results = query.getResultList();
        return results;
    }
    
    //---------------------updates here-------------------------------
    public void updateServiceName(String r, Integer key){
        Service c = em.find(Service.class, key);
        em.getTransaction().begin();
        c.setServiceName(r);
        em.getTransaction().commit();
    }
    

    
    public void updateEventType(String r, Integer key){
        Service b = em.find(Service.class, key);
        em.getTransaction().begin();
        b.setEventType(r);
        em.getTransaction().commit();
    }
    
    
    
    //---------------------deletions here-------------------------------
    public void deleteService(Integer key){
        Service book = em.find(Service.class, key);
        
        ArrayList<Booking> booking_asPrimary = new ArrayList<>(book.getBookingCollection());

        for (Booking tuple : booking_asPrimary) {
            tuple.delete();
        }
        
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }
}
