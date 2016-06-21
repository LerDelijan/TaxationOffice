/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TaxDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Tax;

/**
 *
 * @author Del
 */
@Stateless
public class TaxDao implements TaxDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    @Override
    public List<Tax> getAllTaxes() throws Exception {
        Query query = em.createQuery("SELECT t FROM Tax t", Tax.class);
        return query.getResultList();
    }

    @Override
    public void addNewTax(String tax_name, String tax_sum) throws Exception {
        Tax tax = new Tax();
        tax.setTaxName(tax_name);
        tax.setTaxSum(tax_sum);
        em.persist(tax);
    }
}
