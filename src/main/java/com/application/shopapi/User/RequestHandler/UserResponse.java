package com.application.shopapi.User.RequestHandler;

import com.application.shopapi.ExtraModel.Role;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
@Data
@Value
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class UserResponse {
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
}
