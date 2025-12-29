package com.example.demo.model;

import java.time.LocalDateTime;

public class EvaluationRecord {

    private Long id;
    private Long assignmentId;
    private Integer score;
    private LocalDateTime createdAt;

    public EvaluationRecord() {
        this.createdAt = LocalDateTime.now(); // REQUIRED BY TEST
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
