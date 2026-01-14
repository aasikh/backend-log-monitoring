package com.logmonitor.backend.service;

import com.logmonitor.backend.Entity.ApplicationLog;
import com.logmonitor.backend.repository.ApplicationLogRepository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class ApplicationLogServiceImpl implements ApplicationLogService {

    private final ApplicationLogRepository repository;

    public ApplicationLogServiceImpl(ApplicationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void processLog(ApplicationLog log) {
        Optional result = repository.findByApplicationNameAndServiceNameAndErrorMessage(
                log.getApplicationName(),
                log.getServiceName(),
                log.getErrorMessage()
        );
if(result.isPresent()){
    ApplicationLog dbLog = result.get();
    int currentCount = dbLog.getCount();
    dbLog.setCount(currentCount + 1);
    dbLog.getLastSeen(LocalTime);
}else {

}
    }
}
