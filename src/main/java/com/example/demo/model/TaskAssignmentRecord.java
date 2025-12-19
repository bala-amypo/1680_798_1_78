package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class TaskAssignmentRecord {
@Id @GeneratedValue
private Long id;
private Long taskId;
private Long volunteerId;
private LocalDateTime assignedAt = LocalDateTime.now();
private String status = "ACTIVE";
private String notes;
}