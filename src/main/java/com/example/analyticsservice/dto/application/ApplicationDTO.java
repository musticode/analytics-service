package com.example.analyticsservice.dto.application;

import com.example.analyticsservice.dto.organization.OrganizationDTO;
import com.example.analyticsservice.model.Organization;
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
public class ApplicationDTO {
    private Long id;
    private String name;
    private String appCode;
}
