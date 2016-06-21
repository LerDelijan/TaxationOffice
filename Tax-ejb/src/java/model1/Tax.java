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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t"),
    @NamedQuery(name = "Tax.findByIdtax", query = "SELECT t FROM Tax t WHERE t.idtax = :idtax"),
    @NamedQuery(name = "Tax.findByTaxName", query = "SELECT t FROM Tax t WHERE t.taxName = :taxName"),
    @NamedQuery(name = "Tax.findByTaxSum", query = "SELECT t FROM Tax t WHERE t.taxSum = :taxSum")})
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtax")
    private Integer idtax;
    @Size(max = 45)
    @Column(name = "tax_name")
    private String taxName;
    @Size(max = 45)
    @Column(name = "tax_sum")
    private String taxSum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxAdd")
    private List<Addtax> addtaxList;

    public Tax() {
    }

    public Tax(Integer idtax) {
        this.idtax = idtax;
    }

    public Integer getIdtax() {
        return idtax;
    }

    public void setIdtax(Integer idtax) {
        this.idtax = idtax;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxSum() {
        return taxSum;
    }

    public void setTaxSum(String taxSum) {
        this.taxSum = taxSum;
    }

    @XmlTransient
    public List<Addtax> getAddtaxList() {
        return addtaxList;
    }

    public void setAddtaxList(List<Addtax> addtaxList) {
        this.addtaxList = addtaxList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtax != null ? idtax.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.idtax == null && other.idtax != null) || (this.idtax != null && !this.idtax.equals(other.idtax))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Tax[ idtax=" + idtax + " ]";
    }
    
}
