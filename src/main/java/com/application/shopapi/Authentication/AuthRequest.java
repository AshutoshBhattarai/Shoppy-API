package com.application.shopapi.Authentication;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuthRequest {

    String username;
    String password;
}
