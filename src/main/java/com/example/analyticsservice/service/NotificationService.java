package com.example.analyticsservice.service;

import com.example.analyticsservice.model.es.NotificationEs;

public interface NotificationService {
    NotificationEs saveNotificationToElastic(NotificationEs notificationEs);
}
