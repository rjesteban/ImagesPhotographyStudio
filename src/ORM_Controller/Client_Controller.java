/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM_Controller;
import ORM.Booking;
import java.util.Collection;
import javax.persistence.TypedQuery;
import ORM.Client;
import static ORM_Controller.Controller.em;
import java.util.ArrayList;

/**
 *
 * @author El Gato
 */
public class Client_Controller extends Controller{
    
     //-----------------------read--------------------------------
    public Collection<Client> viewAllClients(){
        TypedQuery<Client> query =
        em.createNamedQuery("Client.findAll", Client.class);
        Collection<Client> results = query.getResultList();
        return results;
    }
    
    public Collection<Client> viewBId(){
        TypedQuery<Client> query =
        em.createNamedQuery("Client.findByBId", Client.class);
        Collection<Client> results = query.getResultList();
        return results;
    }
    
    public Collection<Client> viewAllTypes(){
        TypedQuery<Client> query =
        em.createNamedQuery("Client.findAllClientType", Client.class);
        Collection<Client> results = query.getResultList();
        ArrayList ar = new ArrayList();
        ar.add("Corporate");
        ar.add("Individual");
        
        results.removeAll(ar);
        
        return results;
    }

        public Client findDuplicate(Client _p){
        ArrayList<Client> s = new ArrayList<>(new Client_Controller().viewAllClients());
        if(!s.isEmpty()){
        for(Client r:s){
            if(r.getClientType().equals(_p.getClientType()) &&
               r.getCContactNumber().equals(_p.getCContactNumber()) &&
               r.getCEmailAd().equals(_p.getCEmailAd()) &&
               r.getCFirstname().equals(_p.getCFirstname()) &&
               r.getCLastname().equals(_p.getCLastname())
            )
                return r;
        }
        }
        return null;
    }
    
    public Client findClient(Integer key) {
        Client b = em.find(Client.class, key);
        return b;
    }
        
        
    //---------------------updates here-------------------------------
    public void updateContactNumber(String contact_number, Integer key){
        Client client = em.find(Client.class, key);
        em.getTransaction().begin();
        client.setCContactNumber(contact_number);
        em.getTransaction().commit();
    }
    
    public void updateClientFirstName(String first_name, Integer key){
        Client client = em.find(Client.class, key);
        em.getTransaction().begin();
        client.setCFirstname(first_name);
        em.getTransaction().commit();
    }
    
    public void updateClientLastName(String last_name, Integer key){
        Client client = em.find(Client.class, key);
        em.getTransaction().begin();
        client.setCLastname(last_name);
        em.getTransaction().commit();
    }
    
    public void updateClientType(String _type, Integer key){
        Client client = em.find(Client.class, key);
        em.getTransaction().begin();
        client.setClientType(_type);
        em.getTransaction().commit();
    }
    
    
    public void updateClientEmail(String _email, Integer key){
        Client client = em.find(Client.class, key);
        em.getTransaction().begin();
        client.setCEmailAd(_email);
        em.getTransaction().commit();
    }
    
    public void updateBookingCollection(Collection r, Integer key){
        Client b = em.find(Client.class, key);
        em.getTransaction().begin();
        b.setBookingCollection(r);
        em.getTransaction().commit();
    }
    
    //---------------------deletions here-------------------------------
    public void deleteClient(Integer key){
        Client book = em.find(Client.class, key);
        
        
        ArrayList<Booking> clientsbooking = new ArrayList<>(book.getBookingCollection());

        for (Booking tuple : clientsbooking) {
            tuple.delete();
        }

                
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    
    
}
