package com.example.analyticsservice.repository.mongo;

import com.example.analyticsservice.model.mongo.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface LogMongoRepository extends MongoRepository<Log, String> {
    Log findByMessage(String message);
}
