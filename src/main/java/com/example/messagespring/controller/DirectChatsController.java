package com.example.messagespring.controller;

import com.example.messagespring.entity.DirectChats;
import com.example.messagespring.model.DirectChatsModel;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.repo.DirectChatsRepository;
import com.example.messagespring.service.DirectChatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DirectChatsController {

    private DirectChatsRepository directChatsRepository;
    private final DirectChatsService directChatsService;


    @GetMapping("/directChats")
    public List<DirectChatsModel> getAllDirectChats() {

        List<DirectChats> directChatsList = directChatsRepository.findAll();
        return directChatsList.stream()
                .map(directChat -> {
                    DirectChatsModel model = new DirectChatsModel();
                    model.setChatId(directChat.getChatId());
                    model.setCreatedAt(directChat.getCreatedAt());
                    model.setLastMessageAt(directChat.getLastMessageAt());
                    model.setIsActive(directChat.getIsActive());
                    model.setCreatedBy(directChat.getCreatedBy());
                    UserResponse userResponse1 = new UserResponse();
                    userResponse1.setId(directChat.getUser1().getId());
                    userResponse1.setUsername(directChat.getUser1().getUsername());

                    model.setUser1(userResponse1);

                    UserResponse userResponse2 = new UserResponse();
                    userResponse2.setId(directChat.getUser2().getId());
                    userResponse2.setUsername(directChat.getUser2().getUsername());
                    model.setUser2(userResponse2);
                    return model;
                })
                .toList();
    }

    @GetMapping("/directChats/user")
    public List<DirectChatsModel> getDirectChatsByUserId(@RequestParam Long userId) {
        return directChatsService.getDirectChatsByUserId(userId);
    }



}
