package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.alert.AlertRule;

import java.util.List;

public interface AlertService {
/*    createAlertRule(rule: AlertRule)      |
            | + removeAlertRule(rule: AlertRule)      |
            | + sendNotification(alert: Alert)*/

    AlertRule createAlertRule(AlertRule alertRule);
    AlertRule findAlertRule(long id);

    List<AlertRule> findAllAlerts();

    Void deleteAlertRuleById(long alertId);
}
