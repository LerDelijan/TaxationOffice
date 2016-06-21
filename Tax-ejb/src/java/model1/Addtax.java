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
@Table(name = "addtax")
@NamedQueries({
    @NamedQuery(name = "Addtax.findAll", query = "SELECT a FROM Addtax a"),
    @NamedQuery(name = "Addtax.findByIdaddtax", query = "SELECT a FROM Addtax a WHERE a.idaddtax = :idaddtax")})
public class Addtax implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaddtax")
    private Integer idaddtax;
    
    @JoinColumn(name = "agent_add", referencedColumnName = "idagent")
    @ManyToOne(optional = false)
    private Agent agentAdd;
    
    @JoinColumn(name = "tax_add", referencedColumnName = "idtax")
    @ManyToOne(optional = false)
    private Tax taxAdd;

    public Integer getIdaddtax() {
        return idaddtax;
    }

    public void setIdaddtax(Integer idaddtax) {
        this.idaddtax = idaddtax;
    }

    public Agent getAgentAdd() {
        return agentAdd;
    }

    public void setAgentAdd(Agent agentAdd) {
        this.agentAdd = agentAdd;
    }

    public Tax getTaxAdd() {
        return taxAdd;
    }

    public void setTaxAdd(Tax taxAdd) {
        this.taxAdd = taxAdd;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idaddtax);
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
        final Addtax other = (Addtax) obj;
        return Objects.equals(this.idaddtax, other.idaddtax);
    }
}
