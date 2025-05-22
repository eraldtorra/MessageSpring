package com.example.messagespring.model;

import com.example.messagespring.entity.User;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirectChatsModel {

    private Long chatId;
    private Date createdAt;
    private Date lastMessageAt;
    private Boolean isActive;
    private String createdBy;
    private UserResponse user1;
    private UserResponse user2;
}
