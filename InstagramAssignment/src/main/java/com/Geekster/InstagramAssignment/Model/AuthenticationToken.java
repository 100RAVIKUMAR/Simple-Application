package com.Geekster.InstagramAssignment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenId;

    private String token;

    private LocalDate tokenCreationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "fk_user")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDate.now();
    }
}
