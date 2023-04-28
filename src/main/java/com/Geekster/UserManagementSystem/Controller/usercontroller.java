package com.Geekster.UserManagementSystem.Controller;

import com.Geekster.UserManagementSystem.Model.User;
import com.Geekster.UserManagementSystem.Service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usercontroller {
    @Autowired
    userservice userserv;
@PostMapping(value = "/adduser")
    public String addauser(@Validated @RequestBody User user){
    return userserv.addanuser(user);
}
@GetMapping(value = "getuserbyid/{user_id}")
    public User getuserbyid(@PathVariable String user_id){
    return userserv.getuserinfo(user_id);
}
@GetMapping(value = "getuser")
    public List<User> getallusers(){
    return userserv.getusers();
}
@PutMapping(value = "/update/{user_id}")
    public String updatebyid(@Validated @RequestBody String userid,@PathVariable String user_id){
    return userserv.updateanuser(userid,user_id);
}
@DeleteMapping(value = "delete/{user_id}")
    public String deleteuser(@PathVariable String user_id){
    return userserv.delete1user(user_id);
}
}
