package com.example.analyticsservice.dto.application;

import com.example.analyticsservice.model.Organization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponse {
    private Long id;
    private String name;
    private String appCode;
    private long organizationId;
}
