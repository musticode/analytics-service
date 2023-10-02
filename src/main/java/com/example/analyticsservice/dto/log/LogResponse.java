package com.example.analyticsservice.dto.log;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogResponse {
    private String id;
    private Date timestamp;
    private String source;
    private String message;
    private String severity;
}
