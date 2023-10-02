package com.example.analyticsservice.dto.organization;

import com.example.analyticsservice.model.Application;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationResponse {
    private Long id;
    private String name;
    private String address;
    private int appCount;
    private List<Application> applications;
}
