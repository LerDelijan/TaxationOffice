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
@Table(name = "fine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fine.findAll", query = "SELECT f FROM Fine f"),
    @NamedQuery(name = "Fine.findByIdfine", query = "SELECT f FROM Fine f WHERE f.idfine = :idfine"),
    @NamedQuery(name = "Fine.findByFineName", query = "SELECT f FROM Fine f WHERE f.fineName = :fineName")})
public class Fine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfine")
    private Integer idfine;
    @Size(max = 45)
    @Column(name = "fine_name")
    private String fineName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fineCheck")
    private List<Check> checkList;

    public Fine() {
    }

    public Fine(Integer idfine) {
        this.idfine = idfine;
    }

    public Integer getIdfine() {
        return idfine;
    }

    public void setIdfine(Integer idfine) {
        this.idfine = idfine;
    }

    public String getFineName() {
        return fineName;
    }

    public void setFineName(String fineName) {
        this.fineName = fineName;
    }

    @XmlTransient
    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfine != null ? idfine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fine)) {
            return false;
        }
        Fine other = (Fine) object;
        if ((this.idfine == null && other.idfine != null) || (this.idfine != null && !this.idfine.equals(other.idfine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Fine[ idfine=" + idfine + " ]";
    }
    
}
