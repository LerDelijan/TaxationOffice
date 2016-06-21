/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PostDaoLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Post;

/**
 *
 * @author Del
 */
@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable{
    @EJB
    private PostDaoLocal pdl;
    private String postName;
    private int idpost;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }
    
    public List<Post> getAllPosts() throws Exception {
        return pdl.getAllPosts();
    }
        
    public String addNewPost() throws Exception {
        this.pdl.addNewPost(postName);
        return "posts.xhtml";
    }
}
