package com.example.analyticsservice.repository.mongo;

import com.example.analyticsservice.model.mongo.NotificationMongo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMongoRepository extends JpaRepository<NotificationMongo, String> {
}
