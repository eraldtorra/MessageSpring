package com.example.messagespring;

import com.example.messagespring.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class MessageSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageSpringApplication.class, args);
    }

}
