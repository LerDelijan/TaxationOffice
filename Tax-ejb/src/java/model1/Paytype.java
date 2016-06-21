/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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

/**
 *
 * @author Del
 */
@Entity
@Table(name = "paytype")
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

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idpaytype);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Paytype other = (Paytype) obj;
        return Objects.equals(this.idpaytype, other.idpaytype);
    }
}