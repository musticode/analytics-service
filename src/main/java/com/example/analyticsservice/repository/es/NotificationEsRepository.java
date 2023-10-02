package com.example.analyticsservice.repository.es;

import com.example.analyticsservice.model.es.NotificationEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEsRepository extends ElasticsearchRepository<NotificationEs, String> {
}
