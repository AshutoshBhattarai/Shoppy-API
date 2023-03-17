package com.application.shopapi.User.RequestHandler;

import com.application.shopapi.ExtraModel.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    UUID id;
    String username;
    String password;
    String email;
    Role role;
    String address;
    String firstname;
    String lastname;
    String middlename;
    LocalDate dob;
}
