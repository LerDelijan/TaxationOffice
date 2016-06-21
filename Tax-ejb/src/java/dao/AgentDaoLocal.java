/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Agent;

/**
 *
 * @author Del
 */
@Local
public interface AgentDaoLocal {

    Agent getAgent(int id);

    List<Agent> getAllAgents() throws Exception;

    void addNewAgent(String agent_name, int agent_inn, String agent_head) throws Exception;

}
