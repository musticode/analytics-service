package com.example.analyticsservice.service.impl;


import com.example.analyticsservice.model.User;
import com.example.analyticsservice.repository.postgre.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;



    public User findUserByEmail(String email){
        return userRepository
                .findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException("Not found user with id")
                );
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = findUserByEmail(email);
        List<String> roles = new ArrayList<>();
        roles.add("USER");

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();

        return userDetails;
    }
}
