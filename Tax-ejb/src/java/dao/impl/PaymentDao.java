/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PaymentDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Agent;
import model1.Payment;
import model1.Paytype;

/**
 *
 * @author Del
 */
@Stateless
public class PaymentDao implements PaymentDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    @Override
    public List<Payment> getAllPayments() throws Exception {
        Query query = em.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
    }

    @Override
    public void addNewPayment(int idagent, int idpaytype, int sum) throws Exception {
        Payment payment = new Payment();
        payment.setSum(sum);
        payment.setIdagent(em.getReference(Agent.class, idagent));
        payment.setIdpaytype(em.getReference(Paytype.class, idpaytype));
        em.persist(payment);
        Agent agent = em.getReference(Agent.class, idagent);
        agent.getPaymentList().add(payment);
        em.merge(agent);
        Paytype paytype = em.getReference(Paytype.class, idpaytype);
        paytype.getPaymentList().add(payment);
        em.merge(paytype);
    }
}
