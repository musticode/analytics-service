package com.example.analyticsservice.controller;

import co.elastic.clients.elasticsearch.nodes.Http;
import com.example.analyticsservice.dto.log.LogRequest;
import com.example.analyticsservice.dto.log.LogResponse;
import com.example.analyticsservice.service.LogService;
import com.example.analyticsservice.service.impl.LogEsService;
import com.example.analyticsservice.service.impl.LogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.analyticsservice.constant.LogConstant.LOG_ENDPOINT;

@RestController
@RequestMapping(LOG_ENDPOINT)
@RequiredArgsConstructor
public class LogController {

    private final LogServiceImpl logService;

    @PostMapping
    public ResponseEntity<LogResponse> createLog(@RequestBody LogRequest logRequest){
        return new ResponseEntity<>(logService.createLog(logRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{logId}")
    public ResponseEntity<LogResponse> findLogById(@PathVariable String logId){
        return new ResponseEntity<>(logService.getLogById(logId), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<LogResponse>>findLogs(){
        return new ResponseEntity<>(logService.findLogs(), HttpStatus.OK);
    }

}
