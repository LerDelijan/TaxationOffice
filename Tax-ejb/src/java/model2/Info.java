/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import model1.Agent;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findByIdinfo", query = "SELECT i FROM Info i WHERE i.idinfo = :idinfo"),
    @NamedQuery(name = "Info.findByAccountstate", query = "SELECT i FROM Info i WHERE i.accountstate = :accountstate")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idagent")
    private int idagent;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idinfo")
    private Integer idinfo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountstate")
    private String accountstate;
    
    @Transient
    private Agent agent;


    public Info() {
    }

    public Info(Integer idinfo) {
        this.idinfo = idinfo;
    }

    public Info(Integer idinfo, String accountstate) {
        this.idinfo = idinfo;
        this.accountstate = accountstate;
    }
    public Agent getAgent() {
        return agent;
    }
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Integer getIdinfo() {
        return idinfo;
    }

    public void setIdinfo(Integer idinfo) {
        this.idinfo = idinfo;
    }

    public String getAccountstate() {
        return accountstate;
    }

    public void setAccountstate(String accountstate) {
        this.accountstate = accountstate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfo != null ? idinfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        return !((this.idinfo == null && other.idinfo != null) || (this.idinfo != null && !this.idinfo.equals(other.idinfo)));
    }

    @Override
    public String toString() {
        return "model2.Info[ idinfo=" + idinfo + " ]";
    }

    public int getIdagent() {
        return idagent;
    }

    public void setIdagent(int idagent) {
        this.idagent = idagent;
    }

}
