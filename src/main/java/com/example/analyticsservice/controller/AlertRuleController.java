package com.example.analyticsservice.controller;

import com.example.analyticsservice.dto.alert.AlertRule;
import com.example.analyticsservice.dto.alert.AlertRuleRequest;
import com.example.analyticsservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alert-rule")
@RequiredArgsConstructor
public class AlertRuleController {

    private final AlertService alertService;

    @GetMapping("/{alertId}")
    public ResponseEntity<AlertRule> findAlertRule(@PathVariable long alertId){
        AlertRule alertRule = alertService.findAlertRule(alertId);
        return new ResponseEntity<>(alertRule, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlertRule> findAlertRule(@RequestBody AlertRule rule){
        AlertRule alertRule = alertService.createAlertRule(rule);
        return new ResponseEntity<>(alertRule, HttpStatus.CREATED);
    }

}
