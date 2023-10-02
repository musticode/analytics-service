package com.example.analyticsservice.converter;

import com.example.analyticsservice.dto.log.LogDTO;
import com.example.analyticsservice.model.mongo.Log;

public class LogConverter extends Converter<LogDTO, Log>{

    public LogConverter(){
        super(LogConverter::convertLogToEntity, LogConverter::convertLogToDTO);
    }

    public static LogDTO convertLogToDTO(Log log) {
        return LogDTO.builder()
                .message(log.getMessage())
                .source(log.getSource())
                .timestamp(log.getTimestamp())
                .severity(log.getSeverity())
                .build();
    }

    public static Log convertLogToEntity(LogDTO logDTO) {
        return Log.builder()
                .message(logDTO.getMessage())
                .source(logDTO.getSource())
                .timestamp(logDTO.getTimestamp())
                .severity(logDTO.getSeverity())
                .build();
    }
}
