package com.Geekster.InstagramAssignment.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String firstName;

    private String lastName;

    private Integer age;
    @Email
    private String email;

    private String password;

    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Post> post;


    public User(String firstName, String lastName, Integer age, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
