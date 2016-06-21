/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AddDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Addtax;
import model1.Agent;
import model1.Post;
import model1.Tax;

/**
 *
 * @author Del
 */
@Stateless
public class AddDao implements AddDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    public List<Addtax> getAllAdds() throws Exception {
        Query query = em.createQuery("SELECT ad FROM Addtax ad", Addtax.class);
        return query.getResultList();
    }

    public void addNewAdd(int agent_add, int tax_add) throws Exception {
        Addtax addtax = new Addtax();
        addtax.setAgentAdd(em.getReference(Agent.class, agent_add));
        addtax.setTaxAdd(em.getReference(Tax.class, tax_add));
        em.persist(addtax);
        Agent agent = em.getReference(Agent.class, agent_add);
        agent.getAddtaxList().add(addtax);
        em.merge(agent);
        Tax tax = em.getReference(Tax.class, tax_add);
        tax.getAddtaxList().add(addtax);
        em.merge(tax);
    }
}
