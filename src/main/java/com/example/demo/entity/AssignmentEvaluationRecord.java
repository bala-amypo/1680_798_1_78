package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long assignmentId;
    private Integer rating;
    private String feedback;

    private LocalDateTime evaluatedAt;

    @PrePersist
    public void prePersist() {
        evaluatedAt = LocalDateTime.now();
    }
}
