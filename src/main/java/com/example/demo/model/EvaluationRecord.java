package com.example.demo.model;

import java.time.LocalDateTime;

public class EvaluationRecord {

    private Long id;
    private Long assignmentId;
    private Integer score;
    private LocalDateTime createdAt;
private LocalDateTime evaluatedAt;

public EvaluationRecord() {
    this.evaluatedAt = LocalDateTime.now();
}


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
