/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import java.util.Objects;
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

/**
 *
 * @author Del
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdpayment", query = "SELECT p FROM Payment p WHERE p.idpayment = :idpayment"),
    @NamedQuery(name = "Payment.findBySum", query = "SELECT p FROM Payment p WHERE p.sum = :sum")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpayment")
    private Integer idpayment;
    
    @Column(name = "sum")
    private Integer sum;
    
    @JoinColumn(name = "idagent", referencedColumnName = "idagent")
    @ManyToOne(optional = false)
    private Agent idagent;
    
    @JoinColumn(name = "idpaytype", referencedColumnName = "idpaytype")
    @ManyToOne(optional = false)
    private Paytype idpaytype;

    public Integer getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Agent getIdagent() {
        return idagent;
    }

    public void setIdagent(Agent idagent) {
        this.idagent = idagent;
    }

    public Paytype getIdpaytype() {
        return idpaytype;
    }

    public void setIdpaytype(Paytype idpaytype) {
        this.idpaytype = idpaytype;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idpayment);
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
        final Payment other = (Payment) obj;
        return Objects.equals(this.idpayment, other.idpayment);
    }
}