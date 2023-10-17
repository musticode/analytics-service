package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.alert.AlertRule;
import com.example.analyticsservice.dto.alert.AlertRuleRequest;
import com.example.analyticsservice.exception.alert.AlertNotFoundException;
import com.example.analyticsservice.repository.postgre.AlertRuleRepository;
import com.example.analyticsservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AlertServiceImpl implements AlertService {

    private final AlertRuleRepository alertRuleRepository;
    private final ModelMapper modelMapper;

    @Override
    public AlertRule createAlertRule(AlertRule alertRule) {

        AlertRule newAlertRule = AlertRule.builder()
                .name(alertRule.getName())
                .sendingMailAddress(alertRule.getSendingMailAddress())
                .build();

        log.info("saved alert rule {}", newAlertRule);
        return alertRuleRepository.save(newAlertRule);
    }


    @Override
    public AlertRule findAlertRule(long id){

        AlertRule alertRule = alertRuleRepository
                .findById(id)
                .orElseThrow(()-> new AlertNotFoundException("Alert not found"));

        return alertRule;
    }

    public AlertRule mapToEntity(AlertRuleRequest alertRuleRequest){
        return modelMapper.map(alertRuleRequest, AlertRule.class);
    }


}
