/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Addtax;

/**
 *
 * @author Del
 */
@Local
public interface AddDaoLocal {

    public void addNewAdd(int agent_add, int tax_add) throws Exception;

    public List<Addtax> getAllAdds() throws Exception;
    
}
