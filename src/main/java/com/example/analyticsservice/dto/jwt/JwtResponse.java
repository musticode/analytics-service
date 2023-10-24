package com.example.analyticsservice.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    // https://www.bezkoder.com/spring-boot-jwt-authentication/
    private String token;
    private String username;
    private String roles;
}
