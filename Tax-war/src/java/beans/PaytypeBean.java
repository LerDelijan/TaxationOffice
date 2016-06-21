/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dao.PaytypeDaoLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Paytype;

/**
 *
 * @author Del
 */
@Named(value = "paytypeBean")
@SessionScoped
public class PaytypeBean implements Serializable {

    @EJB
    private PaytypeDaoLocal pdl;
    private int idpaytype;
    private String paytypeName;

    public int getIdpaytype() {
        return idpaytype;
    }

    public void setIdpaytype(int idpaytype) {
        this.idpaytype = idpaytype;
    }

    public String getPaytypeName() {
        return paytypeName;
    }

    public void setPaytypeName(String paytypeName) {
        this.paytypeName = paytypeName;
    }

    public List<Paytype> getAllPaytypes() throws Exception {
        return pdl.getAllPaytypes();
    }
}
