/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model1.Post;

/**
 *
 * @author Del
 */
@Local
public interface PostDaoLocal {

    public List<Post> getAllPosts() throws Exception;

    public void addNewPost(String post_name) throws Exception;
}
