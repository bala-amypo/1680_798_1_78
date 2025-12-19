package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status = "ACTIVE";

    private LocalDateTime assignedAt = LocalDateTime.now();
    private String notes;
}
