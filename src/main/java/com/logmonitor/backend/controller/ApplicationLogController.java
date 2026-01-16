package com.logmonitor.backend.controller;

import com.logmonitor.backend.Entity.ApplicationLog;
import com.logmonitor.backend.service.ApplicationLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class ApplicationLogController {

    private final ApplicationLogService service;

    public ApplicationLogController(ApplicationLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> receiveLog(
            @RequestHeader("X-API-KEY") String apiKey,
            @RequestBody ApplicationLog log
    ) {
        service.processLog(apiKey, log);
        return ResponseEntity.ok("Log processed successfully");
    }
}
