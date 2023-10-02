package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.user.UserCreateRequest;
import com.example.analyticsservice.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreateRequest userCreateRequest);

    UserResponse getUserById(long userId);

    List<UserResponse> getAll();
}
