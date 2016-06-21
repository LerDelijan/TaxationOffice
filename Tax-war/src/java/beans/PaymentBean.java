/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AddDaoLocal;
import dao.PaymentDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import model1.Payment;

/**
 *
 * @author Del
 */
@Named(value = "paymentBean")
@SessionScoped
public class PaymentBean implements Serializable {


    @EJB
    private PaymentDaoLocal pdl;
    
    private int idagent;
    private int idpaytype;
    private int sum;

    public int getIdagent() {
        return idagent;
    }

    public void setIdagent(int idagent) {
        this.idagent = idagent;
    }

    public int getIdpaytype() {
        return idpaytype;
    }

    public void setIdpaytype(int idpaytype) {
        this.idpaytype = idpaytype;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Payment> getAllPayments() throws Exception {
        return pdl.getAllPayments();
    }
    

    public String addNewPayment() throws Exception {
        this.pdl.addNewPayment(idagent, idpaytype, sum);
        return "payment.xhtml";
    }
}
