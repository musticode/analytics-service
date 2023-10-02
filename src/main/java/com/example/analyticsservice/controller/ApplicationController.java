package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.application.ApplicationDTO;
import com.example.analyticsservice.dto.application.ApplicationRequest;
import com.example.analyticsservice.dto.application.ApplicationResponse;
import com.example.analyticsservice.model.Application;
import com.example.analyticsservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationResponse> addApplication(@RequestBody ApplicationRequest applicationRequest){
        return new ResponseEntity<>(applicationService.saveApplication(applicationRequest), HttpStatus.CREATED);
    }

    @GetMapping("{applicationId}")
    public ResponseEntity<ApplicationDTO> getApplication(@PathVariable long applicationId){
        return new ResponseEntity<>(applicationService.getApplicationById(applicationId), HttpStatus.OK);
    }




}
