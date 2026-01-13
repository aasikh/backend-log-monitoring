package com.logmonitor.backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Entity
@Table(name="application_log")

public class ApplicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="application_name", nullable = false, length = 255)
    private String applicationName;

    @Column(name="service_name", nullable = false, length = 255)
    private String serviceName;

    @Column(name="error_message", nullable = false, length = 1000)
    private String ErrorMessage;

    @Column(name="count" , nullable = false)
    private Long Count;

    @Column(name="first_seen", nullable = false)
    private LocalDateTime FirstSeen;

    @Column(name="last_seen", nullable = false)
    private LocalDateTime LastSeen;

    @Column(name="create_at")
    private LocalDateTime CreateAt;

// getter and setter


    public Long getId() {
        return id;
    }
    public void setId(Long  id){
        this.id = id;
    }

    public String getApplicationName(){
        return applicationName;
    }
    public void setApplicationName(String applicationName){
        this.applicationName = applicationName;
    }

    public String getServiceName(){
        return serviceName;
    }
    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public String getErrorMessage(){
        return ErrorMessage;
    }
    public void setErrorMessage(String ErrorMessage){
        this.ErrorMessage= ErrorMessage;
    }

    public Long getCount(){
        return Count;
    }
    public void setCount(Long Count){
        this.Count = Count;
    }

    public LocalDateTime getFirstSeen(){
        return FirstSeen;
    }
    public void setFirstSeen(LocalDateTime FirstSeen){
        this.FirstSeen = FirstSeen;
    }

    public LocalDateTime getLastSeen() {
        return LastSeen;
    }
    public void setLastSeen(LocalDateTime lastSeen) {
        LastSeen = lastSeen;
    }

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        CreateAt = createAt;
    }
}