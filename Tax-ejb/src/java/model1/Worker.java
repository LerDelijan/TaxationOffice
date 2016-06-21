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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findByIdworker", query = "SELECT w FROM Worker w WHERE w.idworker = :idworker"),
    @NamedQuery(name = "Worker.findByWorkerName", query = "SELECT w FROM Worker w WHERE w.workerName = :workerName")})
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idworker")
    private Integer idworker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "worker_name")
    private String workerName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workerCheck")
    private List<Check> checkList;
    @JoinColumn(name = "worker_post", referencedColumnName = "idpost")
    @ManyToOne
    private Post workerPost;

    public Worker() {
    }

    public Worker(Integer idworker) {
        this.idworker = idworker;
    }

    public Worker(Integer idworker, String workerName) {
        this.idworker = idworker;
        this.workerName = workerName;
    }

    public Integer getIdworker() {
        return idworker;
    }

    public void setIdworker(Integer idworker) {
        this.idworker = idworker;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @XmlTransient
    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    public Post getWorkerPost() {
        return workerPost;
    }

    public void setWorkerPost(Post workerPost) {
        this.workerPost = workerPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idworker != null ? idworker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.idworker == null && other.idworker != null) || (this.idworker != null && !this.idworker.equals(other.idworker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Worker[ idworker=" + idworker + " ]";
    }
    
}
