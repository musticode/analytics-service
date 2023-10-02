package com.example.analyticsservice.config;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {


    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private String bootstrapServers = "localhost:9092";

    @Bean
    public NewTopic topic(){
//        admin.setAutoCreate(false);
        return TopicBuilder
                .name(topicName)
                .build();
    }


}
