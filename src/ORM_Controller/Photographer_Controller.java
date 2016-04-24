/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM_Controller;
import ORM.Booking;
import java.util.Collection;
import javax.persistence.TypedQuery;
import ORM.Photographer;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author El Gato
 */
public class Photographer_Controller extends Controller{
    //-----------------------read--------------------------------
    public Collection<Photographer> viewAllPhotographers(){
        TypedQuery<Photographer> query =
        em.createNamedQuery("Photographer.findAll", Photographer.class);
        Collection<Photographer> results = query.getResultList();
        return results;
    }
    
    public Collection<Photographer> viewByBId(){
        TypedQuery<Photographer> query =
        em.createNamedQuery("Photographer.findByBId", Photographer.class);
        Collection<Photographer> results = query.getResultList();
        return results;
    }
    
    public Collection<Photographer> viewAllEmploymentStatus(){
        TypedQuery<Photographer> query =
        em.createNamedQuery("Photographer.findAllEmploymentStatus", Photographer.class);
        Collection<Photographer> results = query.getResultList();
        return results;
    }
    
    public Photographer findDuplicate(Photographer _p){
        ArrayList<Photographer> s = new ArrayList<>(new Photographer_Controller().viewAllPhotographers());
        if(!s.isEmpty()){
            for(Photographer r:s){
            if(r.getEmploymentStatus().equals(_p.getEmploymentStatus()) &&
               r.getPContactNumber().equals(_p.getPContactNumber()) &&
               r.getPEmailAd().equals(_p.getPEmailAd()) &&
               r.getPFirstname().equals(_p.getPFirstname()) &&
               r.getPLastname().equals(_p.getPLastname())
            )
                return r;
        }
        }
        return null;
    }
    
    public Photographer findPhotographer(Integer key){
        Photographer p = em.find(Photographer.class, key);
        return p;
    }
    
    public Collection<Photographer> findAvailablePhotographers(Integer ds, Integer de, Date _r){
        ArrayList<Booking> allBookings = new ArrayList<>(new Booking_Controller().viewAllBookings());
        System.out.println(allBookings.size());
        ArrayList<Photographer> allphotographers = new ArrayList<>(new Photographer_Controller().viewAllPhotographers());
        
            for(Booking b:allBookings){
                
                boolean contained = ((ds<=b.getTimeIn() && de >=b.getTimeOut())||
                    (ds<=b.getTimeIn() && de>=b.getTimeOut())
                    ||
                    (b.getTimeIn()<=ds && b.getTimeOut()>=de)
                    ||
                    (ds<=b.getTimeIn() && de<=b.getTimeOut() && b.getTimeIn()<=de && b.getTimeOut()>=de)
                    ||
                    (ds>=b.getTimeIn() && de>=b.getTimeOut() && b.getTimeIn()<=ds && b.getTimeOut()>=ds));
                boolean sameday = _r.equals(b.getSDate());
                
                if(contained && sameday){
                    allphotographers.remove(b.getApId());
                    allphotographers.remove(b.getPId());
                }
                else{
                    
                }
                    }
        return allphotographers;
    }
    
    
    
    //---------------------updates here-------------------------------
    public void updateContactNumber(String r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setPContactNumber(r);
        em.getTransaction().commit();
    }
    
    public void updateFirstName(String r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setPFirstname(r);
        em.getTransaction().commit();
    }
    
    public void updateLastName(String r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setPLastname(r);
        em.getTransaction().commit();
    }
    
    public void updateEmploymentStatus(String r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setEmploymentStatus(r);
        em.getTransaction().commit();
    }
    
    public void updateEmail(String r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setPEmailAd(r);
        em.getTransaction().commit();
    }
    
    public void updatePrimaryCollection(Collection r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setBookingCollection(r);
        em.getTransaction().commit();
    }
    
    public void updateAssistantCollection(Collection r, Integer key){
        Photographer c = em.find(Photographer.class, key);
        em.getTransaction().begin();
        c.setBookingCollection1(r);
        em.getTransaction().commit();
    }
    

    
    //---------------------deletions here-------------------------------
    public void deletePhotographer(Integer key){
        Photographer book = em.find(Photographer.class, key);
        System.out.println(book);
       ArrayList<Booking> booking_asPrimary = new ArrayList<>(book.getBookingCollection1());
        //System.out.println(booking_asPrimary);
        ArrayList<Booking> booking_asAssistant = new ArrayList<>(book.getBookingCollection());
        
        for(Booking tuple: booking_asPrimary){
            System.out.println(tuple.getBId());
            tuple.setPId(null);
            tuple.setIsArchived(true);
            //booking_asPrimary.remove(tuple);
            tuple.save();
            
        }
        
        
        for(Booking tuple:booking_asAssistant){
            tuple.setApId(null);
            tuple.setIsArchived(true);
            tuple.save();
        }
        
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    
    }
}
