package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.organization.OrganizationDTO;
import com.example.analyticsservice.dto.organization.OrganizationRequest;
import com.example.analyticsservice.dto.organization.OrganizationResponse;
import com.example.analyticsservice.model.Application;
import com.example.analyticsservice.model.Organization;
import com.example.analyticsservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationResponse> addApplication(@RequestBody OrganizationRequest organizationRequest){
        return new ResponseEntity<>(organizationService.saveOrganizationWithApplication(organizationRequest), HttpStatus.CREATED);
    }

    @PostMapping("/model")
    public ResponseEntity<Organization> addOrgWithApplication(@RequestBody Organization organization){
        return new ResponseEntity<>(organizationService.saveApplication2(organization), HttpStatus.CREATED);
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<OrganizationDTO> findOrganizationById(@PathVariable long orgId){
        return new ResponseEntity<>(organizationService.getOrganizationWithId(orgId), HttpStatus.OK);
    }

}
