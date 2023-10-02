package com.example.analyticsservice.dto.organization;

import com.example.analyticsservice.dto.application.ApplicationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationRequest implements Serializable {
    private String name;
    private String address;
    private List<ApplicationRequest> application;
}
