package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.converter.ApplicationConverter;
import com.example.analyticsservice.dto.application.ApplicationDTO;
import com.example.analyticsservice.dto.application.ApplicationRequest;
import com.example.analyticsservice.dto.application.ApplicationResponse;
import com.example.analyticsservice.model.Application;
import com.example.analyticsservice.model.Organization;
import com.example.analyticsservice.repository.ApplicationRepository;
import com.example.analyticsservice.repository.OrganizationRepository;
import com.example.analyticsservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApplicationResponse saveApplication(ApplicationRequest applicationRequest) {
        /**
         *     private String name;
         *     private String appCode;
         *     private long organizationId;
         * */

        Organization organization = organizationRepository
                .findById(applicationRequest.getOrganizationId())
                .orElseThrow(()-> new RuntimeException("No org with this id "+ applicationRequest.getOrganizationId()));


        Application application = Application.builder()
                .name(applicationRequest.getName())
                .appCode(applicationRequest.getAppCode())
                .organization(organization)
                .build();

        //save to postgresql
        applicationRepository.save(application);

        return ApplicationResponse.builder()
                .id(application.getId())
                .name(application.getName())
                .appCode(application.getAppCode())
                .organizationId(organization.getId())
                .build();
    }

    @Override
    public ApplicationDTO getApplicationById(long applicationId) {

        Application application = applicationRepository
                .findById(applicationId)
                .orElseThrow(
                        ()-> new RuntimeException("Not found with id" + applicationId )
                );

        return ApplicationConverter.convertApplicationToDTO(application);
    }




    private ApplicationResponse mapToResponse(Application application){
        return modelMapper.map(application, ApplicationResponse.class);
    }

    public Application mapToEntity(ApplicationRequest applicationRequest){
        return modelMapper.map(applicationRequest, Application.class);
    }


}
