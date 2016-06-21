/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.WorkerDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Worker;

/**
 *
 * @author Del
 */
@Named(value = "workerBean")
@SessionScoped
public class WorkerBean implements Serializable {

    @EJB
    private WorkerDaoLocal wdl;
    private String workerName;
    private int idpost;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public List<Worker> getAllWorkers() throws Exception {
        return wdl.getAllWorkers();
    }
    
    public String addNewWorker() throws Exception {
        this.wdl.addNewWorker(workerName, idpost);
        return "workers.xhtml";
    }
}
