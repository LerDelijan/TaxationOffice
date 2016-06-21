/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Paytype;

/**
 *
 * @author Del
 */
@Local
public interface PaytypeDaoLocal {
    
    Paytype getPaytypeByName(String name);
    List<Paytype> getAllPaytypes();
}
