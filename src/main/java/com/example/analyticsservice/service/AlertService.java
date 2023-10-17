package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.alert.AlertRule;

public interface AlertService {
/*    createAlertRule(rule: AlertRule)      |
            | + removeAlertRule(rule: AlertRule)      |
            | + sendNotification(alert: Alert)*/

    AlertRule createAlertRule(AlertRule alertRule);
    AlertRule findAlertRule(long id);

}
