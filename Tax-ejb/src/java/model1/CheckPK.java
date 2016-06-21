/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Del
 */
@Embeddable
public class CheckPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idcheck")
    private int idcheck;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "agent_check")
    private int agentCheck;

    public CheckPK() {
    }

    public CheckPK(int idcheck, int agentCheck) {
        this.idcheck = idcheck;
        this.agentCheck = agentCheck;
    }

    public int getIdcheck() {
        return idcheck;
    }

    public void setIdcheck(int idcheck) {
        this.idcheck = idcheck;
    }

    public int getAgentCheck() {
        return agentCheck;
    }

    public void setAgentCheck(int agentCheck) {
        this.agentCheck = agentCheck;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcheck;
        hash += (int) agentCheck;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckPK)) {
            return false;
        }
        CheckPK other = (CheckPK) object;
        if (this.idcheck != other.idcheck) {
            return false;
        }
        if (this.agentCheck != other.agentCheck) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model1.CheckPK[ idcheck=" + idcheck + ", agentCheck=" + agentCheck + " ]";
    }
    
}
