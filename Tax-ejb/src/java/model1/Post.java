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
@Table(name = "post")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdpost", query = "SELECT p FROM Post p WHERE p.idpost = :idpost"),
    @NamedQuery(name = "Post.findByPostName", query = "SELECT p FROM Post p WHERE p.postName = :postName")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpost")
    private Integer idpost;
    
    @Size(max = 15)
    @Column(name = "post_name")
    private String postName;
    
    @OneToMany(mappedBy = "workerPost")
    private List<Worker> workerList;

    public Integer getIdpost() {
        return idpost;
    }

    public void setIdpost(Integer idpost) {
        this.idpost = idpost;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idpost);
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
        final Post other = (Post) obj;
        return Objects.equals(this.idpost, other.idpost);
    }
}