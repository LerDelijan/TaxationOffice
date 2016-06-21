/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Tax;

/**
 *
 * @author Del
 */
@Local
public interface TaxDaoLocal{

    void addNewTax(String tax_name, Integer tax_sum) throws Exception;

    List<Tax> getAllTaxes() throws Exception;

}
