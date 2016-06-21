/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AddDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Addtax;

/**
 *
 * @author Del
 */
@Named(value = "addBean")
@SessionScoped
public class AddBean implements Serializable {

    @EJB
    private AddDaoLocal adl;
    private int agentAdd;
    private int taxAdd;

    public int getAgentAdd() {
        return agentAdd;
    }

    public void setAgentAdd(int agentAdd) {
        this.agentAdd = agentAdd;
    }

    public int getTaxAdd() {
        return taxAdd;
    }

    public void setTaxAdd(int taxAdd) {
        this.taxAdd = taxAdd;
    }

    public List<Addtax> getAllAdds() throws Exception {
        return adl.getAllAdds();
    }

    public String addNewAdd() throws Exception {
        this.adl.addNewAdd(agentAdd, taxAdd);
        return "adding.xhtml";
    }
}
