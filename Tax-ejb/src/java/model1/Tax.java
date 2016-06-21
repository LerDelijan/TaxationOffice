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
import javax.persistence.FetchType;
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
@Table(name = "tax")
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t"),
    @NamedQuery(name = "Tax.findByIdtax", query = "SELECT t FROM Tax t WHERE t.idtax = :idtax"),
    @NamedQuery(name = "Tax.findByTaxName", query = "SELECT t FROM Tax t WHERE t.taxName = :taxName"),
    @NamedQuery(name = "Tax.findByTaxSum", query = "SELECT t FROM Tax t WHERE t.taxSum = :taxSum")})
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtax")
    private Integer idtax;
    
    @Size(max = 45)
    @Column(name = "tax_name")
    private String taxName;
    
    @Column(name = "tax_sum")
    private Integer taxSum;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxAdd", fetch = FetchType.LAZY)
    private List<Addtax> addtaxList;

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

    public Integer getTaxSum() {
        return taxSum;
    }

    public void setTaxSum(Integer taxSum) {
        this.taxSum = taxSum;
    }

    public List<Addtax> getAddtaxList() {
        return addtaxList;
    }

    public void setAddtaxList(List<Addtax> addtaxList) {
        this.addtaxList = addtaxList;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idtax);
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
        final Tax other = (Tax) obj;
        return Objects.equals(this.idtax, other.idtax);
    }
}
