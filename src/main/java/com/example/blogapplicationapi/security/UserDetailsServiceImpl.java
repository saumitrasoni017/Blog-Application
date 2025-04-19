package com.example.blogapplicationapi.security;

import com.example.blogapplicationapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.blogapplicationapi.entity.User> optional = userRepository.findByEmail(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("User already exists with this email");
        }
        com.example.blogapplicationapi.entity.User myUser = optional.get();
        return User.builder()
                .username(myUser.getEmail())
                .password(myUser.getPassword())
                .build();
    }

}
