package com.example.analyticsservice.service;

import com.example.analyticsservice.model.es.NotificationEs;
import com.example.analyticsservice.model.mongo.NotificationMongo;

public interface NotificationService {
    NotificationEs saveNotificationToElastic(NotificationEs notificationEs);
    NotificationMongo saveNotificationToMongo(NotificationMongo notificationMongo);
}
