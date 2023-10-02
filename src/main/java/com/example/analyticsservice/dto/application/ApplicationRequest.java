package com.example.analyticsservice.dto.application;

import com.example.analyticsservice.model.Organization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationRequest implements Serializable {
    private String name;
    private String appCode;
    private long organizationId;
}
