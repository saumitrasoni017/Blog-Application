package com.example.blogapplicationapi.controller;

import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.service.UserService;
import com.example.blogapplicationapi.utility.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        User user1 = userService.registerUser(user);

        ResponseStructure<User> responseStructure = new ResponseStructure<User>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("User object created successfully");
        responseStructure.setData(user1);

        return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
    }
}
