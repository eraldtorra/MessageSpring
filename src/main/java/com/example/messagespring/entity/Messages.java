package com.example.messagespring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private String content;
    private Date timestamp;
    private Boolean isRead;
    private Boolean isDelivered;
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private DirectChats directChats;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User user;

}
