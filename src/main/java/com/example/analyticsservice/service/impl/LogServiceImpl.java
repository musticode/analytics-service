package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.event.NotificationEvent;
import com.example.analyticsservice.dto.log.LogDTO;
import com.example.analyticsservice.dto.log.LogRequest;
import com.example.analyticsservice.dto.log.LogResponse;

import com.example.analyticsservice.model.LogData;
import com.example.analyticsservice.model.es.LogEs;
import com.example.analyticsservice.model.mongo.Log;


import com.example.analyticsservice.repository.es.LogEsRepository;
import com.example.analyticsservice.repository.mongo.LogMongoRepository;
import com.example.analyticsservice.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogServiceImpl implements LogService {

    private final LogMongoRepository logMongoRepository;
    private final LogEsRepository logEsRepository;
    private final ModelMapper modelMapper;
    private final LogProducerService logProducerService;

    @Override
    public LogResponse createLog(LogRequest logRequest) {

        Log log = Log.builder()
                .source(logRequest.getSource())
                .message(logRequest.getMessage())
                .timestamp(new Date())
                .severity(logRequest.getSeverity())
                .build();



        LogEs logEs = LogEs.builder()
                .source(logRequest.getSource())
                .timestamp(new Date())
                .severity(logRequest.getSeverity())
                .message(logRequest.getMessage())
                .build();

        logEsRepository.save(logEs);
        logMongoRepository.save(log);

        if (logRequest.getSeverity().equals("MAJOR") || logRequest.getSeverity().equals("MINOR")){

            NotificationEvent notificationEvent = NotificationEvent.builder()
                    .id(UUID.randomUUID().toString())
                    .logData(LogData.builder()
                            .severity(logRequest.getSeverity())
                            .message(logRequest.getMessage())
                            .source(logRequest.getSource())
                            .timestamp(new Date())
                            .build())
                    .build();

            logProducerService.sendMessage(notificationEvent);
        }

        return mapToResponse(log);
    }


    public Log createLogToMongo(LogDTO logDTO){

        Log log = new Log();
        log.setMessage(logDTO.getMessage());
        log.setSeverity(logDTO.getSeverity());
        log.setTimestamp(new Date());
        log.setSource(logDTO.getSource());

        return log;
    }




    @Override
    public LogResponse getLogById(String logId) {

        if (logId.isEmpty() || logId.isBlank()){
            throw new RuntimeException("Log id empty or blank");
        }

        Log logData = logMongoRepository
                .findById(logId)
                .orElseThrow(()-> new RuntimeException("No log with id: " + logId));


        return LogResponse.builder()
                .id(logData.getId())
                .message(logData.getMessage())
                .severity(logData.getSeverity())
                .source(logData.getSource())
                .timestamp(logData.getTimestamp())
                .build();
    }

    @Override
    public List<LogResponse> findLogs(){
        return logMongoRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private LogResponse mapToResponse(Log log){
        return modelMapper.map(log, LogResponse.class);
    }
}
