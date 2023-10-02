package com.example.analyticsservice.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {
    @NotNull @NotEmpty
    private String username;

    @NotNull @NotEmpty
    private String password;

    private String firstName;
    private String lastName;

    private String email;
}
