package com.example.analyticsservice.repository.es;

import com.example.analyticsservice.model.es.LogEs;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogEsRepository extends ElasticsearchRepository<LogEs, String> {
    List<LogEs> findByMessage(String message);
}
