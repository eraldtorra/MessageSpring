package com.example.messagespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String hello() {

        return "Hello World";
    }

    @PostMapping("/auth")
    public String helloPost() {

        return "Hello World";
    }
}
