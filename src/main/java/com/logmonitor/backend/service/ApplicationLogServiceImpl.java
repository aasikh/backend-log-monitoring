package com.logmonitor.backend.service;

import com.logmonitor.backend.Entity.ApplicationLog;
import com.logmonitor.backend.repository.ApplicationLogRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

import java.util.Optional;
@Service
public class ApplicationLogServiceImpl implements ApplicationLogService {

    private final ApplicationLogRepository repository;

    public ApplicationLogServiceImpl(ApplicationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void processLog(String apiKey, ApplicationLog log) {
        Optional<ApplicationLog> result = repository.findByApplicationAndServiceNameAndErrorMessage(
               log.getApplication(),
                log.getServiceName(),
                log.getErrorMessage()
        );
if(result.isPresent()){
   ApplicationLog dbLog = result.get();
   dbLog.setCount(dbLog.getCount() + 1L);
   dbLog.setLastSeen(LocalDateTime.now());
   repository.save(dbLog);
}else {
log.setCount(1L);
log.setLastSeen(LocalDateTime.now());
log.setFirstSeen(LocalDateTime.now());
repository.save(log);
}
    }
}

