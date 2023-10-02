package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.log.LogRequest;
import com.example.analyticsservice.dto.log.LogResponse;

import java.util.List;

public interface LogService {
    LogResponse createLog(LogRequest logRequest);

    LogResponse getLogById(String logId);

    List<LogResponse> findLogs();
}
