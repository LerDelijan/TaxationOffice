/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model1.Agent;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "info")
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findByIdinfo", query = "SELECT i FROM Info i WHERE i.idinfo = :idinfo"),
    @NamedQuery(name = "Info.findByAccountstate", query = "SELECT i FROM Info i WHERE i.accountstate = :accountstate")})
public class Info implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinfo")
    private Integer idinfo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "idagent")
    private int idagent;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountstate")
    private String accountstate;

    @Transient
    private Agent agent;

    public Integer getIdinfo(){
        return idinfo;
    }

    public void setIdinfo(Integer idinfo){
        this.idinfo = idinfo;
    }

    public int getIdagent(){
        return idagent;
    }

    public void setIdagent(int idagent){
        this.idagent = idagent;
    }

    public String getAccountstate(){
        return accountstate;
    }

    public void setAccountstate(String accountstate){
        this.accountstate = accountstate;
    }

    public Agent getAgent(){
        return agent;
    }

    public void setAgent(Agent agent){
        this.agent = agent;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idinfo);
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
        final Info other = (Info) obj;
        return Objects.equals(this.idinfo, other.idinfo);
    }
}
