package com.example.blogapplicationapi.service;

import com.example.blogapplicationapi.entity.User;

public interface UserService {
    public User registerUser(User user);
//    public User loginUser(String email, String password);
   public User getUserByEmail(String email);
}
