package com.logmonitor.backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="application_name", nullable = false, length = 255)
    private String applicationName;

    @Column(name="apiKey", nullable = false, unique = true, length = 1000)
    private String apiKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private  ApplicationStatus status;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
    // -------Getter & Setter-------

    public Long getId(){
       return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public enum ApplicationStatus {
        ACTIVE,
        BLOCKED
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
