/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;

import ORM_Controller.Controller;
import ORM_Controller.Photographer_Controller;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author El Gato
 */
@Entity
@Table(name = "PHOTOGRAPHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photographer.findAll", query = "SELECT p FROM Photographer p"),
    @NamedQuery(name = "Photographer.findByPId", query = "SELECT p FROM Photographer p WHERE p.pId = :pId"),
    @NamedQuery(name = "Photographer.findByPLastname", query = "SELECT p FROM Photographer p WHERE p.pLastname = :pLastname"),
    @NamedQuery(name = "Photographer.findByPFirstname", query = "SELECT p FROM Photographer p WHERE p.pFirstname = :pFirstname"),
    @NamedQuery(name = "Photographer.findByEmploymentStatus", query = "SELECT p FROM Photographer p WHERE p.employmentStatus = :employmentStatus"),
    @NamedQuery(name = "Photographer.findByPEmailAd", query = "SELECT p FROM Photographer p WHERE p.pEmailAd = :pEmailAd"),
    @NamedQuery(name = "Photographer.findByPContactNumber", query = "SELECT p FROM Photographer p WHERE p.pContactNumber = :pContactNumber"),
    @NamedQuery(name = "Photographer.findAllEmploymentStatus", query = "SELECT DISTINCT p.employmentStatus FROM Photographer p")
})
public class Photographer extends Controller implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_ID")
    private Integer pId;
    @Column(name = "P_LASTNAME")
    private String pLastname;
    @Column(name = "P_FIRSTNAME")
    private String pFirstname;
    @Column(name = "EMPLOYMENT_STATUS")
    private String employmentStatus;
    @Column(name = "P_EMAIL_AD")
    private String pEmailAd;
    @Column(name = "P_CONTACT_NUMBER")
    private String pContactNumber;
    @OneToMany(mappedBy = "apId")
    private Collection<Booking> bookingCollection;
    @OneToMany(mappedBy = "pId")
    private Collection<Booking> bookingCollection1;

    public Photographer() {
    }

    public Photographer(Integer pId) {
        this.pId = pId;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        Integer oldPId = this.pId;
        this.pId = pId;
        changeSupport.firePropertyChange("PId", oldPId, pId);
    }

    public String getPLastname() {
        return pLastname;
    }

    public void setPLastname(String pLastname) {
        String oldPLastname = this.pLastname;
        this.pLastname = pLastname;
        changeSupport.firePropertyChange("PLastname", oldPLastname, pLastname);
    }

    public String getPFirstname() {
        return pFirstname;
    }

    public void setPFirstname(String pFirstname) {
        String oldPFirstname = this.pFirstname;
        this.pFirstname = pFirstname;
        changeSupport.firePropertyChange("PFirstname", oldPFirstname, pFirstname);
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        String oldEmploymentStatus = this.employmentStatus;
        this.employmentStatus = employmentStatus;
        changeSupport.firePropertyChange("employmentStatus", oldEmploymentStatus, employmentStatus);
    }

    public String getPEmailAd() {
        return pEmailAd;
    }

    public void setPEmailAd(String pEmailAd) {
        String oldPEmailAd = this.pEmailAd;
        this.pEmailAd = pEmailAd;
        changeSupport.firePropertyChange("PEmailAd", oldPEmailAd, pEmailAd);
    }

    public String getPContactNumber() {
        return pContactNumber;
    }

    public void setPContactNumber(String pContactNumber) {
        String oldPContactNumber = this.pContactNumber;
        this.pContactNumber = pContactNumber;
        changeSupport.firePropertyChange("PContactNumber", oldPContactNumber, pContactNumber);
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection1() {
        return bookingCollection1;
    }

    public void setBookingCollection1(Collection<Booking> bookingCollection1) {
        this.bookingCollection1 = bookingCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photographer)) {
            return false;
        }
        Photographer other = (Photographer) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return //"ORM.Photographer[ pId=" + pId + " ]";
        return "("+ pId + ") " + pLastname + ", " + pFirstname + ": " + pContactNumber;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
  
    
    
}
