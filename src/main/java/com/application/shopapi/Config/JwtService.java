package com.application.shopapi.Config;

import com.application.shopapi.User.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {

    public String getUsername(String jwt) {
        return extractClaims(jwt, Claims::getSubject);
    }

    public String generateToken(UserDetails user) {
        return generateToken(new HashMap<>(), user);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails user)
    {
        String username =getUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = extractClaims(token,Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        Claims claims = getTokenDetails(token);
        return claimResolver.apply(claims);
    }

    private Claims getTokenDetails(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInKey() {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String SECRET_KEY = "655368566D597133743677397A244226452948404D635166546A576E5A723475";
        byte[] key = decoder.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

}
