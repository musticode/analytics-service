package com.example.analyticsservice.dto.alert;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertRuleRequest {
    private String name;
    private String sendingMailAddress;
}
