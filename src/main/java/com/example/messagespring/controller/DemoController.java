package com.example.messagespring.controller;

import com.example.messagespring.dto.login;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DemoController {

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

}
