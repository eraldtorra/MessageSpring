package com.example.messagespring.controller;

import com.example.messagespring.dto.AuthenticationResponse;
import com.example.messagespring.dto.login;
import com.example.messagespring.service.JpaUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final JpaUserDetailsService jpaUserDetailsService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/test")
    public String test(@RequestBody login login) {
        try {

            if (jpaUserDetailsService.checkPassword(login.getUsername(), login.getPassword())) {
                return "welcome";
            } else {
                return "User not found";
            }

        }catch (Exception e){
            return "User not found";
        }
    }
}
