package com.example.messagespring.service;

import com.example.messagespring.entity.DirectChats;
import com.example.messagespring.model.DirectChatsModel;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.repo.DirectChatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectChatsService {

    private final DirectChatsRepository directChatsRepository;



    // Method to get all direct chats from userId

    public List<DirectChatsModel> getDirectChatsByUserId(Long userId) {
        List<DirectChats> directChats = directChatsRepository.findAllByUserId(userId);

        // Map the DirectChats to DirectChatsModel


        return directChats.stream().map(directChat -> {
            DirectChatsModel model = new DirectChatsModel();
            model.setChatId(directChat.getChatId());
            model.setCreatedAt(directChat.getCreatedAt());
            model.setLastMessageAt(directChat.getLastMessageAt());
            model.setIsActive(directChat.getIsActive());
            model.setCreatedBy(directChat.getCreatedBy());

            // Map user1
            UserResponse userResponse1 = new UserResponse();
            userResponse1.setId(directChat.getUser1().getId());
            userResponse1.setUsername(directChat.getUser1().getUsername());
            model.setUser1(userResponse1);
            // Map user2
            UserResponse userResponse2 = new UserResponse();
            userResponse2.setId(directChat.getUser2().getId());
            userResponse2.setUsername(directChat.getUser2().getUsername());
            model.setUser2(userResponse2);

            return model;
        }).toList(
        );
    }

}
