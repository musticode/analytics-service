package com.example.analyticsservice.exception.alert;

public class AlertNotFoundException extends RuntimeException{
    private String message;

    public AlertNotFoundException(String message){
        super(message);
    }
}
