package com.example.analyticsservice.exception.user;

public class UserAlreadyExistException extends RuntimeException{
    private String message;
    public UserAlreadyExistException(String message){
        super(message);
    }
}
