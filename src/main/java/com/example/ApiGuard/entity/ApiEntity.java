package com.example.ApiGuard.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class ApiEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String url;
    private String method;
    private int intervalSeconds;
    private int timeout;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}