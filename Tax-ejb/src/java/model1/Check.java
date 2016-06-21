/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "check")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Check.findAll", query = "SELECT c FROM Check c"),
    @NamedQuery(name = "Check.findByIdcheck", query = "SELECT c FROM Check c WHERE c.checkPK.idcheck = :idcheck"),
    @NamedQuery(name = "Check.findByAgentCheck", query = "SELECT c FROM Check c WHERE c.checkPK.agentCheck = :agentCheck")})
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CheckPK checkPK;
    @JoinColumn(name = "agent_check", referencedColumnName = "idagent", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Agent agent;
    @JoinColumn(name = "fine_check", referencedColumnName = "idfine")
    @ManyToOne(optional = false)
    private Fine fineCheck;
    @JoinColumn(name = "worker_check", referencedColumnName = "idworker")
    @ManyToOne(optional = false)
    private Worker workerCheck;

    public Check() {
    }

    public Check(CheckPK checkPK) {
        this.checkPK = checkPK;
    }

    public Check(int idcheck, int agentCheck) {
        this.checkPK = new CheckPK(idcheck, agentCheck);
    }

    public CheckPK getCheckPK() {
        return checkPK;
    }

    public void setCheckPK(CheckPK checkPK) {
        this.checkPK = checkPK;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Fine getFineCheck() {
        return fineCheck;
    }

    public void setFineCheck(Fine fineCheck) {
        this.fineCheck = fineCheck;
    }

    public Worker getWorkerCheck() {
        return workerCheck;
    }

    public void setWorkerCheck(Worker workerCheck) {
        this.workerCheck = workerCheck;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkPK != null ? checkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Check)) {
            return false;
        }
        Check other = (Check) object;
        if ((this.checkPK == null && other.checkPK != null) || (this.checkPK != null && !this.checkPK.equals(other.checkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.Check[ checkPK=" + checkPK + " ]";
    }
    
}
