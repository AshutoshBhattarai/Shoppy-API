package com.application.shopapi.Authentication;

import com.application.shopapi.Config.JwtService;
import com.application.shopapi.User.UserModel;
import com.application.shopapi.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    AuthenticationManager manager;
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepo userRepo;

    public AuthResponse authUser(AuthRequest request) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        ));
        var user = userRepo.findByEmail(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder().token(jwtToken).build();
    }
}
