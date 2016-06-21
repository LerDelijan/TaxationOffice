/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PaytypeDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Paytype;

/**
 *
 * @author Del
 */
@Stateless
public class PaytypeDao implements PaytypeDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    @Override
    public Paytype getPaytypeByName(String name) {
        Query q = em.createNamedQuery("Paytype.findByPaytypeName");
        return (Paytype) q.getSingleResult();
    }

    @Override
    public List<Paytype> getAllPaytypes() {
        return em.createNamedQuery("Paytype.findAll").getResultList();
    }
    
}
