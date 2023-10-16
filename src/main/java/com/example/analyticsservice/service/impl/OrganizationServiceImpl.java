package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.converter.OrganizationConverter;
import com.example.analyticsservice.dto.application.ApplicationRequest;
import com.example.analyticsservice.dto.organization.OrganizationDTO;
import com.example.analyticsservice.dto.organization.OrganizationRequest;
import com.example.analyticsservice.dto.organization.OrganizationResponse;
import com.example.analyticsservice.model.Application;
import com.example.analyticsservice.model.Organization;
import com.example.analyticsservice.repository.postgre.ApplicationRepository;
import com.example.analyticsservice.repository.postgre.OrganizationRepository;
import com.example.analyticsservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;


    @Override
    public OrganizationResponse saveOrganizationWithApplication(OrganizationRequest organizationRequest) {

        Organization organization = new Organization();
        organization.setName(organizationRequest.getName());
        organization.setAddress(organization.getAddress());
        organizationRepository.save(organization);

        List<Application> applications = organizationRequest
                .getApplication()
                .stream()
                .map(item-> modelMapper.map(item, Application.class))
                .collect(Collectors.toList());

        applications.forEach(item-> log.info("Application: "  + item.toString()));
        applications.forEach(item-> item.setOrganization(organization));
        applications.forEach(item-> applicationRepository.save(item));


        //OrganizationDTO organizationDTO = OrganizationConverter.convertOrganizationToDto(organization);


        return OrganizationResponse.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .appCount(organization.getAppCount())
                .applications(organization.getApplications())
                .build();
    }

    @Override
    public Organization saveApplication2(Organization organization) {

        Application app = new Application();
        app.setName("appName");
        app.setAppCode("appCodeTest1");
//        applicationRepository.save(app);

        Application app2 = new Application();
        app2.setName("appName2");
        app2.setAppCode("appCodeTest2");
//        applicationRepository.save(app2);
        List<Application> appList = List.of(app,app2);


        Organization org = new Organization();
        org.setName("Name Test");
        org.setAddress("Test Address");
        org.setAppCount(12);
        org.setApplications(appList);




        organizationRepository.save(org);

        app.setOrganization(org);
        app2.setOrganization(org);

        applicationRepository.save(app);
        applicationRepository.save(app2);
        //önce parentı ekle kaydet
        //sonra child'lara parent'ı kaydet


        return org;


/*
        //application list
        List<Application> applications = organization
                .getApplications()
                .stream()
                .collect(Collectors.toList());

        //save all applications
        applications.forEach(
                application -> applicationRepository.save(application)
        );

        Organization newOrganization = new Organization();
        newOrganization.setName(organization.getName());
        newOrganization.setAppCount(organization.getAppCount());
        newOrganization.setAddress(organization.getAddress());
        newOrganization.setApplications(applications);

        return newOrganization;*/






        /**

        List<Application> applications = organization.getApplications().stream().collect(Collectors.toList());

        applications.forEach(application -> System.out.println(application));

        for (Application app : applications){
            applicationRepository.save(app);
            log.info("APP saved:" +  app.getName());
        }

        Organization organization1 = new Organization();
        organization1.setName(organization.getName());
        organization1.setId(organization.getId());
        organization1.setAddress(organization.getAddress());
        organization1.setAppCount(organization.getAppCount());

        organization1.setApplications(applications);



        organizationRepository.save(organization1);


        return organization1;
         */

    }

    @Override
    public OrganizationDTO getOrganizationWithId(long orgId) {

        Organization organization = organizationRepository
                .findById(orgId)
                .orElseThrow(
                        ()-> new RuntimeException("No org with id "+ orgId)
                );

        return OrganizationConverter.convertOrganizationToDto(organization);
    }

    public Application mapToApplication(ApplicationRequest applicationRequest){
        return Application.builder()
                .name(applicationRequest.getName())
                .appCode(applicationRequest.getAppCode())
                .build();
    }

}
