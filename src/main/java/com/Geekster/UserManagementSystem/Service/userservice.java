package com.Geekster.UserManagementSystem.Service;

import com.Geekster.UserManagementSystem.Model.User;
import com.Geekster.UserManagementSystem.Repository.userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userservice {
    @Autowired
    userdao userrepo;

    public  String addanuser(User user) {
        return userrepo.addoneuser(user);
    }

    public User getuserinfo(String userId) {
        List<User>reference=userrepo.gerallusers();
        for(User user:reference){
            if(user.getUser_id().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public List<User> getusers() {
        List<User>reference=userrepo.gerallusers();
        return reference;
    }

    public String updateanuser(String userid, String userId) {
        return userrepo.updatetheinfo(userid,userId);
    }

    public String delete1user(String userId) {
        return userrepo.deletuser(userId);
    }
}
