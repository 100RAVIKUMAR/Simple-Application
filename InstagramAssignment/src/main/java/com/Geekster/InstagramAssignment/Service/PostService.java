package com.Geekster.InstagramAssignment.Service;

import com.Geekster.InstagramAssignment.Model.Post;
import com.Geekster.InstagramAssignment.Model.User;
import com.Geekster.InstagramAssignment.Repository.PostDao;
import com.Geekster.InstagramAssignment.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;

    public void addapost(Post post) {
        postDao.save(post);
    }


    public List<Post> getapost(String token, String gmail) {
        User user=userDao.findByEmail(gmail);
        return user.getPost();
    }
}
