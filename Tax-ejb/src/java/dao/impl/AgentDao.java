/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AgentDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Agent;

/**
 *
 * @author Del
 */
@Stateless
public class AgentDao implements AgentDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    @Override
    public List<Agent> getAllAgents() throws Exception {
        Query query = em.createQuery("SELECT a FROM Agent a", Agent.class);
        return query.getResultList();
    }

    @Override
    public void addNewAgent(String agent_name, int agent_inn, String agent_head) throws Exception {
        Agent agent = new Agent();
        agent.setAgentName(agent_name);
        agent.setAgentInn(String.valueOf(agent_inn));
        agent.setAgentHead(agent_head);
        em.persist(agent);
    }

    @Override
    public Agent getAgent(int id) {
        return em.find(Agent.class, id);
    }
}
