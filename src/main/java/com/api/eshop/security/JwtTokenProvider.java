package com.api.eshop.security;

import com.api.eshop.domain.Users;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtTokenProvider {
    //step 1 : generate the token
    public String generateToken(Authentication authentication) {
        Users users = (Users) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);

        String userId = Long.toString(users.getId());
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", Long.toString(users.getId()));
        claims.put("username", users.getUsername());
        claims.put("role", users.getRole());


        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET_KEY)
                .compact();

    }



    //step 2 : validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("invalid JWT signature");
        } catch (MalformedJwtException ex) {
            System.out.println("invalid Jwt token");
        } catch (ExpiredJwtException ex) {
            System.out.println("expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("unsupported JWT token \n"+ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("jwt claims string is empty");
        }
        return false;
    }

    //step 3 : get user id from token
    public int getUserIdFormJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET_KEY).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");
        return Integer.parseInt(id);
    }
}
