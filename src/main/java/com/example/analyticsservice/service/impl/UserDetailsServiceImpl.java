package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.user.UserDetailsImpl;
import com.example.analyticsservice.model.User;
import com.example.analyticsservice.repository.postgre.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(username)
                .orElseThrow(
                ()-> new UsernameNotFoundException("User name is not found")
                );

        return UserDetailsImpl.build(user);
    }
}
