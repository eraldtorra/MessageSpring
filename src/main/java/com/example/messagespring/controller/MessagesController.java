package com.example.messagespring.controller;

import com.example.messagespring.entity.Messages;
import com.example.messagespring.model.DirectChatsModel;
import com.example.messagespring.model.MessagesModel;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.repo.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MessagesController {

    private MessagesRepository messagesRepository;


    @GetMapping("/messages")
    public List<MessagesModel> getAllMessages() {

        List<Messages> messagesList = messagesRepository.findAll();
        return messagesList.stream()
                .map(message -> {
                    MessagesModel model = new MessagesModel();
                    model.setMessageId(message.getMessageId());
                    model.setContent(message.getContent());
                    model.setTimestamp(message.getTimestamp());
                    model.setIsRead(message.getIsRead());
                    model.setIsDelivered(message.getIsDelivered());
                    model.setCreatedBy(message.getCreatedBy());

                    // Assuming you have a method to convert User to UserResponse
                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(message.getUser().getId());
                    userResponse.setUsername(message.getUser().getUsername());
                    model.setUser(userResponse);

                    // Assuming you have a method to convert DirectChats to DirectChatsModel
                    DirectChatsModel directChatsModel = new DirectChatsModel();
                    directChatsModel.setChatId(message.getDirectChats().getChatId());
                    directChatsModel.setCreatedAt(message.getDirectChats().getCreatedAt());
                    directChatsModel.setLastMessageAt(message.getDirectChats().getLastMessageAt());
                    directChatsModel.setIsActive(message.getDirectChats().getIsActive());
                    directChatsModel.setCreatedBy(message.getDirectChats().getCreatedBy());

                    model.setDirectChats(directChatsModel);

                    return model;
                })
                .toList();

    }
}
