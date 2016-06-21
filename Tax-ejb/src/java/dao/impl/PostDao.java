/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PostDaoLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model1.Post;

/**
 *
 * @author Del
 */
@Stateless
public class PostDao implements PostDaoLocal {

    @PersistenceContext(unitName = "Tax-ejbPU1")
    private EntityManager em;

    @Override
    public List<Post> getAllPosts() throws Exception {
        Query query = em.createQuery("SELECT p FROM Post p", Post.class);
        return query.getResultList();
    }
    
    @Override
    public void addNewPost(String post_name) throws Exception {
        Post post = new Post();
        post.setPostName(post_name);
        em.persist(post);
    }
}
