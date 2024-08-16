package com.identityservice.services.abstracts;

import com.identityservice.services.dtos.LoginRequest;
import com.identityservice.services.dtos.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);

}
