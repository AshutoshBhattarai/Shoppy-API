package com.application.shopapi.Authentication;

import com.application.shopapi.ExtraModel.APIResponse;
import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    String token;
}
