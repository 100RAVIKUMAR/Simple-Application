package com.Geekster.InstagramAssignment.Dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupInput {

    private String firstName;

    private String lastName;

    private Integer age;
    @Email
    private String email;

    private String password;

    private String phoneNumber;
}
