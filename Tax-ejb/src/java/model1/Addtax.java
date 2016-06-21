/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "addtax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addtax.findAll", query = "SELECT a FROM Addtax a"),
    @NamedQuery(name = "Addtax.findByIdaddtax", query = "SELECT a FROM Addtax a WHERE a.idaddtax = :idaddtax")})
public class Addtax implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idaddtax")
    private Integer idaddtax;
    @JoinColumn(name = "agent_add", referencedColumnName = "idagent")
    @ManyToOne(optional = false)
    private Agent agentAdd;
    @JoinColumn(name = "tax_add", referencedColumnName = "idtax")
    @ManyToOne(optional = false)
    private Tax taxAdd;

    public Addtax() {
    }

    public Addtax(Integer idaddtax) {
        this.idaddtax = idaddtax;
    }

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
    public int hashCode() {
        int hash = 0;
        hash += (idaddtax != null ? idaddtax.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addtax)) {
            return false;
        }
        Addtax other = (Addtax) object;
        if ((this.idaddtax == null && other.idaddtax != null) || (this.idaddtax != null && !this.idaddtax.equals(other.idaddtax))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Addtax[ idaddtax=" + idaddtax + " ]";
    }
    
}
