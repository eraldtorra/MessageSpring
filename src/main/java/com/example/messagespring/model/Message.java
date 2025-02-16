package com.example.messagespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Message {
    private Long id;
    private String content;
    private String sender;


    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public Message(Long id, String content, String sender) {
        this.id = id;
        this.content = content;
        this.sender = sender;
    }
}
