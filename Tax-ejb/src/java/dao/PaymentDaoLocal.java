/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Payment;

/**
 *
 * @author Del
 */
@Local
public interface PaymentDaoLocal {

    public List<Payment> getAllPayments() throws Exception;

    public void addNewPayment(int idagent, int idpaytype, int sum) throws Exception;
    
}
