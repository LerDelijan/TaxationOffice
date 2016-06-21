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
@Table(name = "fine")
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

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idfine);
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
        final Fine other = (Fine) obj;
        return Objects.equals(this.idfine, other.idfine);
    }
}
