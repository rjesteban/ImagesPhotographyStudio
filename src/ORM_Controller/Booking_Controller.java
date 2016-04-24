/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM_Controller;
import java.util.Collection;
import javax.persistence.TypedQuery;
import ORM.Booking;
import static ORM_Controller.Controller.em;
import java.util.Date;

/**
 *
 * @author El Gato
 */
public class Booking_Controller extends Controller{
    
    
    //-----------------------read--------------------------------
    public Collection<Booking> viewAllBookings(){
        TypedQuery<Booking> query =
        em.createNamedQuery("Booking.findAll", Booking.class);
        Collection<Booking> results = query.getResultList();
        return results;
    }
    
    public Collection<Booking> viewBId(){
        TypedQuery<Booking> query =
        em.createNamedQuery("Booking.findByBId", Booking.class);
        Collection<Booking> results = query.getResultList();
        return results;
    }
    public Collection<Booking> viewAllByDateAndTime(){
        TypedQuery<Booking> query =
        em.createNamedQuery("Booking.findByDateAll", Booking.class);
        Collection<Booking> results = query.getResultList();
        return results;
    }
    
    public Booking findBooking(Integer key) {
        Booking b = em.find(Booking.class, key);
        return b;
    }
    
    //---------------------updates here-------------------------------
    public void updateLocation(String r, Integer key){
        Booking b = em.find(Booking.class, key);
        em.getTransaction().begin();
        b.setLocation(r);
        em.getTransaction().commit();
    }
    
    public void updateDate(Date r, Integer key){
        Booking b = em.find(Booking.class, key);
        em.getTransaction().begin();
        b.setSDate(r);
        em.getTransaction().commit();
    }
    
    public void updateTime_in(Integer r, Integer key){
        Booking b = em.find(Booking.class, key);
        em.getTransaction().begin();
        b.setTimeIn(r);
        em.getTransaction().commit();
    }
    
    public void updateTime_out(Integer r, Integer key){
        Booking b = em.find(Booking.class, key);
        em.getTransaction().begin();
        b.setTimeOut(r);
        em.getTransaction().commit();
    }
    
    //---------------------deletions here-------------------------------
    public Booking deleteBooking(Integer key){
        Booking book = em.find(Booking.class, key);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        return book;
    }

    
    
    
}
