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
@Table(name = "agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findByIdagent", query = "SELECT a FROM Agent a WHERE a.idagent = :idagent"),
    @NamedQuery(name = "Agent.findByAgentName", query = "SELECT a FROM Agent a WHERE a.agentName = :agentName"),
    @NamedQuery(name = "Agent.findByAgentInn", query = "SELECT a FROM Agent a WHERE a.agentInn = :agentInn"),
    @NamedQuery(name = "Agent.findByAgentHead", query = "SELECT a FROM Agent a WHERE a.agentHead = :agentHead")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagent")
    private Integer idagent;
    @Size(max = 45)
    @Column(name = "agent_name")
    private String agentName;
    @Size(max = 45)
    @Column(name = "agent_inn")
    private String agentInn;
    @Size(max = 45)
    @Column(name = "agent_head")
    private String agentHead;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagent")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private List<Check> checkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentAdd")
    private List<Addtax> addtaxList;

    public Agent() {
    }

    public Agent(Integer idagent) {
        this.idagent = idagent;
    }

    public Integer getIdagent() {
        return idagent;
    }

    public void setIdagent(Integer idagent) {
        this.idagent = idagent;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentInn() {
        return agentInn;
    }

    public void setAgentInn(String agentInn) {
        this.agentInn = agentInn;
    }

    public String getAgentHead() {
        return agentHead;
    }

    public void setAgentHead(String agentHead) {
        this.agentHead = agentHead;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
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
        hash += (idagent != null ? idagent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.idagent == null && other.idagent != null) || (this.idagent != null && !this.idagent.equals(other.idagent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Agent[ idagent=" + idagent + " ]";
    }
    
}
