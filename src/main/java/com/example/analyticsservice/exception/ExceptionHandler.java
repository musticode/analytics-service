package com.example.analyticsservice.exception;

import com.example.analyticsservice.dto.ErrorResponse;
import com.example.analyticsservice.exception.alert.AlertNotFoundException;
import com.example.analyticsservice.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({AlertNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(AlertNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
