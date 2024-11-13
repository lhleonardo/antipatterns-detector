package com.lhleonardo.antipatterns.detector.microservices.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Microservice source;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Microservice target;

    private Long durationInMilliseconds;

    @CreatedDate
    private LocalDateTime createdAt;
}
