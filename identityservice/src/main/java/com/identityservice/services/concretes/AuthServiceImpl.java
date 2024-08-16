package com.identityservice.services.concretes;

import com.etiya.common.jwt.JwtService;
import com.identityservice.services.abstracts.AuthService;
import com.identityservice.services.abstracts.UserService;
import com.identityservice.services.dtos.LoginRequest;
import com.identityservice.services.dtos.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;


    @Override
    public void register(RegisterRequest registerRequest) {
      userService.add(registerRequest);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        if(!authentication.isAuthenticated())
            throw new RuntimeException("E-posta veya şifre hatalı");
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        return jwtService.generateToken(user.getUsername(),user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
