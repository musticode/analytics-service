package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.jwt.JwtResponse;
import com.example.analyticsservice.dto.user.LoginRequest;
import com.example.analyticsservice.dto.user.LoginResponse;
import com.example.analyticsservice.dto.user.SignupRequest;
import com.example.analyticsservice.model.User;
import com.example.analyticsservice.security.JwtUtil;
import com.example.analyticsservice.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    // https://medium.com/code-with-farhan/spring-security-jwt-authentication-authorization-a2c6860be3cf

    private final AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginReq){
        JwtResponse jwtResponse = authService.authenticateUser(loginReq);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest){
        String response = authService.register(signupRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }







}
