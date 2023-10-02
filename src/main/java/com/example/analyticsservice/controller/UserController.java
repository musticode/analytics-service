package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.user.UserCreateRequest;
import com.example.analyticsservice.dto.user.UserResponse;
import com.example.analyticsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.analyticsservice.constant.UserConstant.*;

@RestController
@RequestMapping(USER_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(REGISTER)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest){
        return new ResponseEntity<>(userService.createUser(userCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping(GET_USER_BY_ID)
    public ResponseEntity<UserResponse> getUserById(@PathVariable long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }




}
