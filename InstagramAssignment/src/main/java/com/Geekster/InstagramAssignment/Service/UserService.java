package com.Geekster.InstagramAssignment.Service;

import com.Geekster.InstagramAssignment.Dto.SigninInput;
import com.Geekster.InstagramAssignment.Dto.SigninOutput;
import com.Geekster.InstagramAssignment.Dto.SignupInput;
import com.Geekster.InstagramAssignment.Dto.SignupOutput;
import com.Geekster.InstagramAssignment.Model.AuthenticationToken;
import com.Geekster.InstagramAssignment.Model.User;
import com.Geekster.InstagramAssignment.Repository.UserDao;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public SignupOutput signup(SignupInput input) {
        User user1=userDao.findByEmail(input.getEmail());
        if(user1!=null){
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }


        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(input.getPassword());
        }
        catch (NoSuchAlgorithmException e){
             System.out.println("Cannot encrypt Password");
        }


        user1=new User(input.getFirstName(),input.getLastName(),input.getAge(),input.getEmail(),
                encryptedPassword,input.getPhoneNumber());

        userDao.save(user1);

        authenticationTokenService.createtoken(user1);

        return new SignupOutput("User registered","User created successfully");
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SigninOutput signin(SigninInput inputin) {

        User user=userDao.findByEmail(inputin.getEmail());

        if(user==null){
            throw new IllegalStateException("User Doesn't exists!!!!...sign Up instead");
        }


        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(inputin.getPassword());
        }
        catch (NoSuchAlgorithmException e){
            System.out.println("Cannot encrypt Password");
        }

        Boolean isPasswordvalis=encryptedPassword.equals(user.getPassword());

        if(!isPasswordvalis){
            throw new IllegalStateException("User doesn't exist signup insted..");
        }


        AuthenticationToken token=authenticationTokenService.gettoken(user);


        return new SigninOutput("Authentication Successful",token.getToken());
    }

    @Transactional
    @Modifying
    public void updateuser(String PhoneNumber,String PHNO) {

        User user=userDao.findByphoneNumber(PhoneNumber);
        user.setPhoneNumber(PHNO);
    }
}
