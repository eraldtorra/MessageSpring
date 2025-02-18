package com.example.messagespring.service;

import com.example.messagespring.repo.UserRepository;
import com.example.messagespring.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// method to create a bean of type UserDetailsService
@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var u = userRepository.findByUsername(username);

        return u.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }


    // method for password if password is data
    public Boolean checkPassword(String username, String password) {
        var u = userRepository.findByUsername(username);
        if (u.isPresent()) {
            return u.get().getPassword().equals(password);
        }
        return false;
    }


}
