package com.example.messagespring.service;

import com.example.messagespring.entity.MessageEntity;
import com.example.messagespring.model.Message;
import com.example.messagespring.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public void sendMessage(Message message) {
        System.out.println("Message received: " + message.getContent());
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent(message.getContent());
        messageEntity.setSender(message.getSender());
        messageRepository.save(messageEntity);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(messageEntity -> new Message(messageEntity.getId(),messageEntity.getContent(), messageEntity.getSender()))
                .collect(Collectors.toList());
    }
}
