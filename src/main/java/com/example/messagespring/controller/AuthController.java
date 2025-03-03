package com.example.messagespring.controller;

import com.example.messagespring.dto.Register;
import com.example.messagespring.dto.Token;
import com.example.messagespring.entity.User;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.service.AuthService;
import com.example.messagespring.service.JpaUserDetailsService;
import com.example.messagespring.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final AuthService authService;


    @PostMapping("/token")
    public Token token(Authentication authentication) {
        try {
            LOG.info("Token request for user: {}", authentication.getName());
            Token token = new Token();
            token.setToken(tokenService.generateToken(authentication));
            return token;
        } catch (Exception e) {
            LOG.error("Error generating token: {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/tokenIs")
    public String logout(HttpServletRequest request) {

        return tokenService.logout(request);
    }

    @GetMapping("isToken")
    public Boolean isToken() {
        return tokenService.extractToken();
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody Register user) {
        return authService.register(user);
    }

}
