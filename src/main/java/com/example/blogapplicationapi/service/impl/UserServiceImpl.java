package com.example.blogapplicationapi.service.impl;

import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.exception.InvalidCredentialsException;
import com.example.blogapplicationapi.exception.UserAlreadyExistException;
import com.example.blogapplicationapi.exception.UserNotFoundException;
import com.example.blogapplicationapi.repository.UserRepository;
import com.example.blogapplicationapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User already exist");
        }else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
           return userRepository.save(user);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

}
