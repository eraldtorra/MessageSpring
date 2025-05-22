package com.example.messagespring.controller;

import com.example.messagespring.dto.login;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DemoController {


    private final UserService userService;

    @GetMapping("/demo")
    public String demo(Principal principal) {

        // how to get the current token
        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();


        System.out.println("Token: "+token);
        return "Hello "+ principal.getName();
    }

    @GetMapping("/demo1")
    public Boolean demo1() {
        return true;
    }


    // find search by username

    @GetMapping("/search")
    public UserResponse getUserByUsername(@RequestParam String username) {

        return userService.getUserByUsername(username);
    }



}
