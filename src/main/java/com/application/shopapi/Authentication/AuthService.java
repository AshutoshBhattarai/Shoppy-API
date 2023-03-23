package com.application.shopapi.Authentication;

import com.application.shopapi.AuthConfig.JwtService;
import com.application.shopapi.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepo userRepo;

    public AuthResponse authUser(AuthRequest request) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        ));
        var user = userRepo.findByUsername(request.getUsername()).orElseThrow();
        HashMap<String, Object> extras = new HashMap<String, Object>();
        extras.put("role", user.getRole());
        var jwtToken = jwtService.generateToken(extras,user);
        return AuthResponse.builder().token("Bearer "+jwtToken).build();
    }
}
