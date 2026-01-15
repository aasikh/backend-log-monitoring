package com.logmonitor.backend.controller;

import com.logmonitor.backend.Entity.ApplicationLog;
import com.logmonitor.backend.service.ApplicationLogService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logs")
public class ApplicationLogController {

    private  final ApplicationLogService service;

    public ApplicationLogController(ApplicationLogService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody ApplicationLog log){
        service.processLog(log);
        return ResponseEntity.ok("Log process Successfull");
    }

}
