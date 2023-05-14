package com.Geekster.InstagramAssignment.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "postId")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    private LocalDate createdDate;

    private LocalDate updatedDate;

    private String postData;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
