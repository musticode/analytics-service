package com.example.analyticsservice.repository.mongo;

import com.example.analyticsservice.model.mongo.NotificationMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMongoRepository extends MongoRepository<NotificationMongo, String> {
    NotificationMongo findByMessage(String message);
}
