package com.application.shopapi.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    UUID id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(unique = true, nullable = false)
    String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    enum Role {
        CUSTOMER, ADMIN
    }
}

