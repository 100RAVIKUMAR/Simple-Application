package com.Geekster.UserManagementSystem.Repository;

import com.Geekster.UserManagementSystem.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class userdao {
    private List<User> userdata;

    public userdao() {
        userdata = new ArrayList<>();

    }

    public String addoneuser(User user) {
        userdata.add(user);
        return "user added successfukky...";
    }
    public List<User> gerallusers(){
        return userdata;
    }

    public String updatetheinfo(String userid, String userId) {
        for(User user:userdata){
            if(user.getUser_id().equals(userId)){
                user.setUser_id(userid);
                return "user updated successfully.....";
            }
        }
        return "user doesn't exist..!!!!";
    }

    public String deletuser(String userId) {
        for(User user:userdata){
            if (user.getUser_id().equals(userId)) {
                userdata.remove(user);
                return "Deleted an user successfully....";
            }
        }
        return "no such user exists in database...!!!!!";
    }
}
