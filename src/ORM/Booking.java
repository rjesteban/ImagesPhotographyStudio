/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;

import ORM_Controller.Controller;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author El Gato
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBId", query = "SELECT b FROM Booking b WHERE b.bId = :bId"),
    @NamedQuery(name = "Booking.findBySDate", query = "SELECT b FROM Booking b WHERE b.sDate = :sDate"),
    @NamedQuery(name = "Booking.findByTimeIn", query = "SELECT b FROM Booking b WHERE b.timeIn = :timeIn"),
    @NamedQuery(name = "Booking.findByTimeOut", query = "SELECT b FROM Booking b WHERE b.timeOut = :timeOut"),
    @NamedQuery(name = "Booking.findByLocation", query = "SELECT b FROM Booking b WHERE b.location = :location"),
    @NamedQuery(name = "Booking.findByIsArchived", query = "SELECT b FROM Booking b WHERE b.isArchived = :isArchived"),
    @NamedQuery(name = "Booking.findByDateAll", query = "SELECT b FROM Booking b ORDER BY b.sDate,b.timeIn,b.pId")
})
public class Booking extends Controller implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "B_ID")
    private Integer bId;
    @Column(name = "S_DATE")
    @Temporal(TemporalType.DATE)
    private Date sDate;
    @Column(name = "TIME_IN")
    private Integer timeIn;
    @Column(name = "TIME_OUT")
    private Integer timeOut;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "IS_ARCHIVED")
    private Boolean isArchived;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne
    private Client cId;
    @JoinColumn(name = "AP_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Photographer apId;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Photographer pId;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne
    private Service sId;

    public Booking() {
    }

    public Booking(Integer bId) {
        this.bId = bId;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public Date getSDate() {
        return sDate;
    }

    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }

    public Integer getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Integer timeIn) {
        this.timeIn = timeIn;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public Client getCId() {
        return cId;
    }

    public void setCId(Client cId) {
        this.cId = cId;
    }

    public Photographer getApId() {
        return apId;
    }

    public void setApId(Photographer apId) {
        this.apId = apId;
    }

    public Photographer getPId() {
        return pId;
    }

    public void setPId(Photographer pId) {
        this.pId = pId;
    }

    public Service getSId() {
        return sId;
    }

    public void setSId(Service sId) {
        this.sId = sId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+bId;
    }

    public void delete(){
        em.getTransaction().begin();
        em.remove(this);
        em.getTransaction().commit();
    }
}
