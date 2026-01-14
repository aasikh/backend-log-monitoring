package com.logmonitor.backend.repository;
import com.logmonitor.backend.Entity.ApplicationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ApplicationLogRepository extends JpaRepository <ApplicationLog, Long>{
    Optional<ApplicationLog>    findByApplicationNameAndServiceNameAndErrorMessage(
        String ApplicationName,
        String ServiceName ,
        String ErrorMessage
    );
}

