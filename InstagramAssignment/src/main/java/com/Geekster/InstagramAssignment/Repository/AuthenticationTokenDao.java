package com.Geekster.InstagramAssignment.Repository;

import com.Geekster.InstagramAssignment.Model.AuthenticationToken;
import com.Geekster.InstagramAssignment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationTokenDao extends JpaRepository<AuthenticationToken,Long> {

     AuthenticationToken getByuser(User user);

     AuthenticationToken findByToken(String tooken);
}
