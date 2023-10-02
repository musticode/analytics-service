package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.event.NotificationEvent;
import com.example.analyticsservice.model.es.NotificationEs;
import com.example.analyticsservice.repository.es.NotificationEsRepository;
import com.example.analyticsservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationEsRepository notificationEsRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(NotificationEvent notificationEvent){
        System.out.println("Notification event is sent");
        log.info(notificationEvent.toString());

        NotificationEs notificationEs = NotificationEs.builder()
                .source(notificationEvent.getLogData().getSource())
                .timestamp(notificationEvent.getLogData().getTimestamp())
                .severity(notificationEvent.getLogData().getSeverity())
                .message(notificationEvent.getLogData().getMessage())
                .build();

        saveNotificationToElastic(notificationEs);


        sendNotificationToUsers(notificationEvent);
    }

    @Override
    public NotificationEs saveNotificationToElastic(NotificationEs notificationEs) {

        NotificationEs savedNotification = NotificationEs.builder()
                .source(notificationEs.getSource())
                .timestamp(notificationEs.getTimestamp())
                .severity(notificationEs.getSeverity())
                .message(notificationEs.getMessage())
                .build();

        notificationEsRepository.save(savedNotification);
        log.info("Notification saved {}", savedNotification);

        return savedNotification;
    }

    private void sendNotificationToUsers(NotificationEvent notificationEvent){
        System.out.println("Notification is sent to users...!");
    }
}
