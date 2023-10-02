package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.user.UserCreateRequest;
import com.example.analyticsservice.dto.user.UserResponse;
import com.example.analyticsservice.exception.user.UserNotFoundException;
import com.example.analyticsservice.exception.user.UserAlreadyExistException;
import com.example.analyticsservice.model.User;
import com.example.analyticsservice.repository.UserRepository;
import com.example.analyticsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {

        if (userRepository.existsUserByUsername(userCreateRequest.getUsername())){

            log.info("User already exists with {}", userCreateRequest.getUsername());

            throw new UserAlreadyExistException("User is exist with: "+ userCreateRequest.getUsername());
        }

        User user  = User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .username(userCreateRequest.getUsername())
                .password(userCreateRequest.getPassword())
                .email(userCreateRequest.getEmail())
                .build();


        userRepository.save(user);
        log.info("User saved with : {}", user.toString());


        return mapToResponse(user);
    }

    @Override
    public UserResponse getUserById(long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with: " + userId));

        log.info("User found with : {}", user.toString());

        return mapToResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private UserResponse mapToResponse(User user){
        return modelMapper.map(user, UserResponse.class);
    }


}
