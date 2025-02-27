package com.example.messagespring.controller;

import com.example.messagespring.dto.AuthenticationResponse;
import com.example.messagespring.dto.login;
import com.example.messagespring.service.JpaUserDetailsService;
import com.example.messagespring.service.TokenService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final JpaUserDetailsService jpaUserDetailsService;
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;


    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.info("Token request for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.info("Token generated: {}", token);
        return token;
    }

}
