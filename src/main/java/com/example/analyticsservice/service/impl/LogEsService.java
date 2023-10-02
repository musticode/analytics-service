package com.example.analyticsservice.service.impl;

import com.example.analyticsservice.dto.log.LogRequest;
import com.example.analyticsservice.dto.log.LogResponse;
import com.example.analyticsservice.model.es.LogEs;
import com.example.analyticsservice.repository.es.LogEsRepository;
import com.example.analyticsservice.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogEsService implements LogService {

    private final LogEsRepository logEsRepository;
    private final ModelMapper modelMapper;

    public LogEs saveLogToEs(LogEs logEs){

        if (logEs == null ){
            throw new RuntimeException();
        }

        LogEs savedLog = logEsRepository.save(logEs);
        log.info("Saved to ES {}", savedLog.toString());
        return savedLog;
    }

    @Override
    public LogResponse createLog(LogRequest logRequest) {

        LogEs logEs = LogEs.builder()
                .source(logRequest.getSource())
                .timestamp(new Date())
                .severity(logRequest.getSeverity())
                .message(logRequest.getMessage())
                .build();

        saveLogToEs(logEs);

        return LogResponse.builder()
                .id(logEs.getId())
                .message(logEs.getMessage())
                .timestamp(logEs.getTimestamp())
                .severity(logEs.getSeverity())
                .build();
    }

    @Override
    public LogResponse getLogById(String logId) {
        LogEs logEs = logEsRepository
                .findById(logId)
                .orElseThrow(()-> new RuntimeException("No log with " + logId));
        return modelMapper.map(logEs, LogResponse.class);
    }

    @Override
    public List<LogResponse> findLogs() {

        return null;
    }
}
