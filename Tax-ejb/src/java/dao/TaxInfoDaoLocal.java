/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model2.Info;

/**
 *
 * @author Del
 */
@Local
public interface TaxInfoDaoLocal {

    List<Info> getAllInfos();
    void updateInfo(Info info);
}
