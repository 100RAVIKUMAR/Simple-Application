package com.Geekster.InstagramAssignment.Service;

import com.Geekster.InstagramAssignment.Model.AuthenticationToken;
import com.Geekster.InstagramAssignment.Model.User;
import com.Geekster.InstagramAssignment.Repository.AuthenticationTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService  {
    @Autowired
    AuthenticationTokenDao authenticationTokenDao;

    public void createtoken(User user) {
        AuthenticationToken authtoken=new AuthenticationToken(user);
        authenticationTokenDao.save(authtoken);
    }

    public AuthenticationToken gettoken(User user) {
       return authenticationTokenDao.getByuser(user);
    }


    public boolean authenticate(String tooken) {
        AuthenticationToken authhtoken = authenticationTokenDao.findByToken(tooken);
        return authhtoken.getToken().equals(tooken);
    }

    public AuthenticationToken getByToken(String tooken) {
        return authenticationTokenDao.findByToken(tooken);
    }
}
