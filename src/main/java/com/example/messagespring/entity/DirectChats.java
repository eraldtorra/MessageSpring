package com.example.messagespring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class DirectChats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    private Date createdAt;
    private Date lastMessageAt;
    private Boolean isActive;
    private String createdBy;


    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;


    @OneToMany(mappedBy = "directChats")
    private Set<Messages> messages;

}
