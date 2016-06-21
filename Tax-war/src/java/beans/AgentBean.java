/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AgentDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Agent;

/**
 *
 * @author Del
 */
@Named(value = "agentBean")
@SessionScoped
public class AgentBean implements Serializable {

    @EJB
    private AgentDaoLocal adl;
    private String agentName;
    private int agentInn;
    private String agentHead;
    private int idAgent;

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public int getAgentInn() {
        return agentInn;
    }

    public void setAgentInn(int agentInn) {
        this.agentInn = agentInn;
    }

    public String getAgentHead() {
        return agentHead;
    }

    public void setAgentHead(String agentHead) {
        this.agentHead = agentHead;
    }

    public List<Agent> getAllAgents() throws Exception {
        return adl.getAllAgents();
    }

    public String addNewAgent() throws Exception {
        this.adl.addNewAgent(agentName, agentInn, agentHead);
        return "agents.xhtml";
    }
}
