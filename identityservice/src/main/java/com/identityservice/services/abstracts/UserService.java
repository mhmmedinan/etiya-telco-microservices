package com.identityservice.services.abstracts;

import com.identityservice.services.dtos.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void add(RegisterRequest registerRequest);
}
