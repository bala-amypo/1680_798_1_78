package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;
    private Integer rating;
    private String feedback;

    private LocalDateTime evaluatedAt;

    @PrePersist
    public void onEval() {
        evaluatedAt = LocalDateTime.now();
    }
}
