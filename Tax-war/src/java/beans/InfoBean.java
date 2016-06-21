/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PaymentDaoLocal;
import dao.TaxDaoLocal;
import dao.TaxInfoDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
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
    private TaxDaoLocal taxDao;

    @EJB
    private PaymentDaoLocal paymentDao;

    @EJB
    private TaxInfoDaoLocal taxInfoDao;

    public List<Info> getAllInfos() {
        return taxInfoDao.getAllInfos();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateInfo(Info info) {
        taxInfoDao.updateInfo(info);
    }
}
