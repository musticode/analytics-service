package com.example.analyticsservice.dto.event;

import com.example.analyticsservice.model.LogData;
import com.example.analyticsservice.model.mongo.Log;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEvent {
    private String id;
    private LogData logData;
}
