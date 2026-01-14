package com.logmonitor.backend.service;


import com.logmonitor.backend.Entity.ApplicationLog;

public interface ApplicationLogService {

    public void processLog(ApplicationLog log);
}
