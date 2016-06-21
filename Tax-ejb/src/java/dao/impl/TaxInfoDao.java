/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AgentDaoLocal;
import dao.TaxInfoDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model2.Info;

/**
 *
 * @author Del
 */
@Stateless
public class TaxInfoDao implements TaxInfoDaoLocal {

    @EJB
    private AgentDaoLocal agentDao;

    @PersistenceContext(unitName = "Tax-ejbPU2")
    private EntityManager em;
    
    
    @Override
    public List<Info> getAllInfos() {
        List<Info> result = em.createNamedQuery("Info.findAll").getResultList();
        result.stream().forEach(info -> {
            info.setAgent(agentDao.getAgent(info.getIdagent()));
        });
        return result;
    }

    @Override
    public void updateInfo(Info info) {
        em.merge(info);
    }

}
