package com.Geekster.InstagramAssignment.Repository;

import com.Geekster.InstagramAssignment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByEmail(String email);


    User findByphoneNumber(String phoneNumber);
}
