/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.TaxDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Tax;

/**
 *
 * @author Del
 */
@Named(value = "taxBean")
@SessionScoped
public class TaxBean implements Serializable {

    @EJB
    private TaxDaoLocal tdl;
    private String taxName;
    private String taxSum;
    private int idTax;

    public int getIdTax() {
        return idTax;
    }

    public void setIdTax(int idTax) {
        this.idTax = idTax;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxSum() {
        return taxSum;
    }

    public void setTaxSum(String taxSum) {
        this.taxSum = taxSum;
    }


    public List<Tax> getAllTaxes() throws Exception {
        return tdl.getAllTaxes();
    }

    public String addNewTax() throws Exception {
        this.tdl.addNewTax(taxName, taxSum);
        return "taxes.xhtml";
    }

}
