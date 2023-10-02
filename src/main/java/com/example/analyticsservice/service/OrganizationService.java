package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.organization.OrganizationDTO;
import com.example.analyticsservice.dto.organization.OrganizationRequest;
import com.example.analyticsservice.dto.organization.OrganizationResponse;
import com.example.analyticsservice.model.Organization;

public interface OrganizationService {
    OrganizationResponse saveOrganizationWithApplication(OrganizationRequest organizationRequest);

    Organization saveApplication2(Organization organization);

    OrganizationDTO getOrganizationWithId(long orgId);
}
