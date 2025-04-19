package com.example.blogapplicationapi.service.impl;

import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.repository.UserRepository;
import com.example.blogapplicationapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }else{
           return userRepository.save(user);
        }
    }
}
