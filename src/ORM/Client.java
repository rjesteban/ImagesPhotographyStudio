/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;

import ORM_Controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author El Gato
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByCId", query = "SELECT c FROM Client c WHERE c.cId = :cId"),
    @NamedQuery(name = "Client.findByCLastname", query = "SELECT c FROM Client c WHERE c.cLastname = :cLastname"),
    @NamedQuery(name = "Client.findByCFirstname", query = "SELECT c FROM Client c WHERE c.cFirstname = :cFirstname"),
    @NamedQuery(name = "Client.findByClientType", query = "SELECT c FROM Client c WHERE c.clientType = :clientType"),
    @NamedQuery(name = "Client.findByCEmailAd", query = "SELECT c FROM Client c WHERE c.cEmailAd = :cEmailAd"),
    @NamedQuery(name = "Client.findByCContactNumber", query = "SELECT c FROM Client c WHERE c.cContactNumber = :cContactNumber"),
    @NamedQuery(name = "Client.findAllClientType", query = "SELECT DISTINCT c.clientType FROM Client c")
})
public class Client extends Controller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "C_ID")
    private Integer cId;
    @Column(name = "C_LASTNAME")
    private String cLastname;
    @Column(name = "C_FIRSTNAME")
    private String cFirstname;
    @Column(name = "CLIENT_TYPE")
    private String clientType;
    @Column(name = "C_EMAIL_AD")
    private String cEmailAd;
    @Column(name = "C_CONTACT_NUMBER")
    private String cContactNumber;
    @OneToMany(mappedBy = "cId")
    private Collection<Booking> bookingCollection;

    public Client() {
    }

    public Client(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCLastname() {
        return cLastname;
    }

    public void setCLastname(String cLastname) {
        this.cLastname = cLastname;
    }

    public String getCFirstname() {
        return cFirstname;
    }

    public void setCFirstname(String cFirstname) {
        this.cFirstname = cFirstname;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getCEmailAd() {
        return cEmailAd;
    }

    public void setCEmailAd(String cEmailAd) {
        this.cEmailAd = cEmailAd;
    }

    public String getCContactNumber() {
        return cContactNumber;
    }

    public void setCContactNumber(String cContactNumber) {
        this.cContactNumber = cContactNumber;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cId + " " + cLastname + ", " + cFirstname;
    }

 

}
