package com.example.analyticsservice.converter;

import com.example.analyticsservice.dto.log.LogDTO;
import com.example.analyticsservice.dto.organization.OrganizationDTO;
import com.example.analyticsservice.model.Organization;
import com.example.analyticsservice.model.mongo.Log;
import java.util.stream.Collectors;
public class OrganizationConverter extends Converter<OrganizationDTO, Organization>{

    public OrganizationConverter(){
        super(OrganizationConverter::convertOrganizationDtoToEntity, OrganizationConverter::convertOrganizationToDto);
    }

    public static OrganizationDTO convertOrganizationToDto(Organization organization) {
        return OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .appCount(organization.getAppCount())
                .address(organization.getAddress())
                .applications(organization
                        .getApplications()
                        .stream()
                        .map(ApplicationConverter::convertApplicationToDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }



    public static Organization convertOrganizationDtoToEntity(OrganizationDTO organizationDTO) {
        return Organization.builder()
                .name(organizationDTO.getName())
                .address(organizationDTO.getAddress())
                .appCount(organizationDTO.getAppCount())
                .applications(organizationDTO
                        .getApplications()
                        .stream()
                        .map(ApplicationConverter::convertApplicationToEntity)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
