package com.example.messagespring.controller;

import com.example.messagespring.dto.login;
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

        return "Hello "+ principal.getName();
    }

    @PostMapping("/auth")
    public String helloPost(@RequestBody login login) {
        System.out.println(login.getUsername());
        if (login.getUsername() == null)
        {
            throw new NullPointerException();
        }

        return "Hello World";
    }
}
