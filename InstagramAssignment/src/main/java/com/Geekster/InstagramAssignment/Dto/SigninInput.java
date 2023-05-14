package com.Geekster.InstagramAssignment.Dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninInput {

    @Email
    private String email;
    private String password;
}
