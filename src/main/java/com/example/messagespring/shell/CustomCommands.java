package com.example.messagespring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class CustomCommands {

    @ShellMethod(key = "hello", value = "Say hello")
    public String hello(@ShellOption(defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @ShellMethod(key = "add", value = "Add two numbers")
    public int add(int a, int b) {
        return a + b;
    }
}
