package com.Geekster.InstagramAssignment.Controller;

import com.Geekster.InstagramAssignment.Dto.SigninInput;
import com.Geekster.InstagramAssignment.Dto.SigninOutput;
import com.Geekster.InstagramAssignment.Dto.SignupInput;
import com.Geekster.InstagramAssignment.Dto.SignupOutput;
import com.Geekster.InstagramAssignment.Model.AuthenticationToken;
import com.Geekster.InstagramAssignment.Model.User;
import com.Geekster.InstagramAssignment.Service.AuthenticationTokenService;
import com.Geekster.InstagramAssignment.Service.UserService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationTokenService authservice;

    @PostMapping("/signup")
    public SignupOutput signup(@RequestBody SignupInput input){
           return userService.signup(input);
    }
   @PostMapping("/signin")
    public SigninOutput signin(@RequestBody SigninInput inputin){
        return userService.signin(inputin);
   }

   @PutMapping("/update/{tooken}/{PhoneNumber}/{PHNO}")
    public ResponseEntity<Void> updateuser(@PathVariable String tooken,@PathVariable String PhoneNumber,@PathVariable String PHNO){
       HttpStatus status;

       if(authservice.authenticate(tooken)){
           userService.updateuser(PhoneNumber,PHNO);
           status = HttpStatus.OK;
       }else
       {
           status = HttpStatus.FORBIDDEN;
       }

       return new ResponseEntity<Void>(status);

   }

}
