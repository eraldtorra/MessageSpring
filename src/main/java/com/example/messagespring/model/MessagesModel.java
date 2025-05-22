package com.example.messagespring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagesModel {

    private Long messageId;
    private String content;
    private Date timestamp;
    private Boolean isRead;
    private Boolean isDelivered;
    private String createdBy;

    private UserResponse user;
    private DirectChatsModel directChats;
}
