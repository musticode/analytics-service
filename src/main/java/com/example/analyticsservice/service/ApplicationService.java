package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.application.ApplicationDTO;
import com.example.analyticsservice.dto.application.ApplicationRequest;
import com.example.analyticsservice.dto.application.ApplicationResponse;
import com.example.analyticsservice.model.Application;

public interface ApplicationService {
    ApplicationResponse saveApplication(ApplicationRequest applicationRequest);

    ApplicationDTO getApplicationById(long applicationId);
}
