/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "paytype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paytype.findAll", query = "SELECT p FROM Paytype p"),
    @NamedQuery(name = "Paytype.findByIdpaytype", query = "SELECT p FROM Paytype p WHERE p.idpaytype = :idpaytype"),
    @NamedQuery(name = "Paytype.findByPaytypeName", query = "SELECT p FROM Paytype p WHERE p.paytypeName = :paytypeName")})
public class Paytype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaytype")
    private Integer idpaytype;
    @Size(max = 45)
    @Column(name = "paytype_name")
    private String paytypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaytype")
    private List<Payment> paymentList;

    public Paytype() {
    }

    public Paytype(Integer idpaytype) {
        this.idpaytype = idpaytype;
    }

    public Integer getIdpaytype() {
        return idpaytype;
    }

    public void setIdpaytype(Integer idpaytype) {
        this.idpaytype = idpaytype;
    }

    public String getPaytypeName() {
        return paytypeName;
    }

    public void setPaytypeName(String paytypeName) {
        this.paytypeName = paytypeName;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaytype != null ? idpaytype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paytype)) {
            return false;
        }
        Paytype other = (Paytype) object;
        if ((this.idpaytype == null && other.idpaytype != null) || (this.idpaytype != null && !this.idpaytype.equals(other.idpaytype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Paytype[ idpaytype=" + idpaytype + " ]";
    }
    
}
