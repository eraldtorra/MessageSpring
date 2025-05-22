package com.example.messagespring.service;

import com.example.messagespring.entity.User;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    // Method to get user by username
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).get();

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getAuthorities().stream().findFirst().get().getName());

        return userResponse;
    }

}
