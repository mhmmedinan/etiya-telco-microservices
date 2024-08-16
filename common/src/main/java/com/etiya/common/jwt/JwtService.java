package com.etiya.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtService {


    private static final String SECRET_KEY = "C53m0R5fXD2VXQwoWbV6Rhqk44l/fY0n6rk67028lFw9ZCU9nIpc0V6N1S7hNGHSj6nNGKszIHMUCGxOwatyQXtcA+HmkiCGtO19bhhVEEhfDVxdYP/PLDTnolseuAMP9bYYmXPUXZ/79iRq90kIsM37Uiw/Q3xFFjHObjzzD78ZP8ucmaavcEBTeW9dpOieMvyS7Zdz4ut/slMtIpq1gKBKBw+r3e3sUbUGmoINGJoBsPEQflbE10J1aTRLLREq1EmUNw9VZmVOtCrVErwKawkQFVniWieqAeQze+OY1BfkjYI11lhO7Y7LyOl3Vx35EezWhrYj8ceajsnEr7CIMg==";

    private static final long EXPIRATION=600000;

    public String generateToken(String userName, List<String> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return createToken(claims, userName);
    }

    public Boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public List<String> extractRoles(String token) {
        return getClaimsFromToken(token).get("roles", List.class);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    private Date extractExpiration(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
