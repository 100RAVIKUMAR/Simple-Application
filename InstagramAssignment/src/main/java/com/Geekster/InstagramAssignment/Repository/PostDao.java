package com.Geekster.InstagramAssignment.Repository;

import com.Geekster.InstagramAssignment.Model.AuthenticationToken;
import com.Geekster.InstagramAssignment.Model.Post;
import com.Geekster.InstagramAssignment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post,Integer>{


}
