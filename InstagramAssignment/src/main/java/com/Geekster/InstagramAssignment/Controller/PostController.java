package com.Geekster.InstagramAssignment.Controller;

import com.Geekster.InstagramAssignment.Model.Post;
import com.Geekster.InstagramAssignment.Service.AuthenticationTokenService;
import com.Geekster.InstagramAssignment.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    AuthenticationTokenService authservice;

        @PostMapping("/addpost/{token}")
    public ResponseEntity<Void> addapost(@RequestBody Post post, @PathVariable String token){
        HttpStatus status;
      if(authservice.authenticate(token)){
          postService.addapost(post);
          status=HttpStatus.OK;
      }
    else
    {
        status = HttpStatus.FORBIDDEN;
    }

       return new ResponseEntity<Void>(status);

    }

    @GetMapping("/fetchpost/{token}/{gmail}")
    public List<Post> getapost(@PathVariable String token,@PathVariable String gmail){
        List<Post> posts=null;
        if(authservice.authenticate(token)){
            posts=postService.getapost(token,gmail);
        }
        return posts;
    }

}
