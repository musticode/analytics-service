package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogProducerService {

    private final NewTopic topic;
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public void sendMessage(NotificationEvent event){
        // create message
        Message<NotificationEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
