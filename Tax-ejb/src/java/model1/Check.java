/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Del
 */
@Entity
@Table(name = "checks")
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
    public int hashCode(){
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.checkPK);
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
        final Check other = (Check) obj;
        return Objects.equals(this.checkPK, other.checkPK);
    }
}
