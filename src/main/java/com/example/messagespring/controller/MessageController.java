package com.example.messagespring.controller;

import com.example.messagespring.model.Message;
import com.example.messagespring.entity.MessageEntity;
import com.example.messagespring.repo.MessageRepository;
import com.example.messagespring.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MessageController {



    private MessageService messageService;

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        messageService.sendMessage(message);
        return message;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() throws Exception {
        return messageService.getAllMessages();
    }

}