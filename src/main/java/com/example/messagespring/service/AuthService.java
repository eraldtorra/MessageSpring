package com.example.messagespring.service;

import com.example.messagespring.dto.Register;
import com.example.messagespring.entity.Authority;
import com.example.messagespring.entity.User;
import com.example.messagespring.model.UserResponse;
import com.example.messagespring.repo.AuthorityRepository;
import com.example.messagespring.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;


    public UserResponse register(Register user) {
        User u = new User();
        Authority a = authorityRepository.getAuthorityById(2);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setAuthorities(Set.of(a));

        User savedUser = userRepository.save(u);

        // Map to DTO
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setRole(savedUser.getAuthorities().iterator().next().getName());

        return response;
    }
}
