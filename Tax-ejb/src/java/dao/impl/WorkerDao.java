/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.WorkerDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Post;
import model1.Worker;

/**
 *
 * @author Del
 */
@Stateless
public class WorkerDao implements WorkerDaoLocal {

@PersistenceContext(unitName="Tax-ejbPU1")    
private EntityManager em;

    @Override
    public List<Worker> getAllWorkers() throws Exception {
        return em.createNamedQuery("Worker.findAll").getResultList();
    }
    
    @Override
    public void addNewWorker(String worker_name, int idpost) throws Exception {
        Worker worker = new Worker();
        worker.setWorkerName(worker_name);
        worker.setWorkerPost(em.getReference(Post.class, idpost));
        em.persist(worker);
        Post post = em.getReference(Post.class, idpost);
        post.getWorkerList().add(worker);
        em.merge(post);
    }
}
