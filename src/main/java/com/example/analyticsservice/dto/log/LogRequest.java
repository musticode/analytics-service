package com.example.analyticsservice.dto.log;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogRequest {
    @NotNull
    @NotEmpty(message = "Source can't be empty")
    private String source;

    @NotNull
    @NotEmpty(message = "Message can't be empty")
    @NotBlank
    private String message;

    @NotNull
    @NotEmpty(message = "Severity can't be empty")
    private String severity;

}
