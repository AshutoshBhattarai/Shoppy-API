package com.application.shopapi.User.RequestHandler;

import com.application.shopapi.ExtraModel.Role;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdminResponse {

    UUID id;
    String username;
    String password;
    String email;
    Role role;
    String firstname;
    String lastname;
    String middlename;
    String address;
    LocalDate dob;
    LocalDate createdAt;
    LocalDate updatedAt;
    Boolean isActive;
}
