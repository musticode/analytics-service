package com.example.analyticsservice.dto.organization;

import com.example.analyticsservice.dto.application.ApplicationDTO;
import com.example.analyticsservice.model.Application;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;
    private int appCount;
    private List<ApplicationDTO> applications;

}
