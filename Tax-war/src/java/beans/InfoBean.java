/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AgentDaoLocal;
import dao.TaxInfoDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import model1.Addtax;
import model1.Agent;
import model1.Payment;
import model2.Info;

/**
 *
 * @author Del
 */
@Named
@SessionScoped
@Transactional
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class InfoBean implements Serializable{

    @EJB
    private AgentDaoLocal agentDao;

    @EJB
    private TaxInfoDaoLocal taxInfoDao;

    public List<Info> getAllInfos(){
        return taxInfoDao.getAllInfos();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateInfo(Info info){
        Agent agent = agentDao.getAgent(info.getIdagent());
        int taxesSum = 0;
        int paymentsSum = 0;
        for (Addtax a : agent.getAddtaxList()) {
            taxesSum += a.getTaxAdd().getTaxSum();
        }
        for (Payment p : agent.getPaymentList()) {
            paymentsSum += p.getSum();
        }
        info.setAccountstate(paymentsSum >= taxesSum ? "+" : "-");
        taxInfoDao.updateInfo(info);
    }
}
