/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Worker;

/**
 *
 * @author Del
 */
@Local
public interface WorkerDaoLocal {

    public List<Worker> getAllWorkers() throws Exception;

    public void addNewWorker(String worker_name, int idpost) throws Exception;

}
