package com.example.blogapplicationapi.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found by email");
    }
}
