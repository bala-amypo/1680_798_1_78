package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignment_records")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status; // ACTIVE / COMPLETED

    public TaskAssignmentRecord() {}

    public TaskAssignmentRecord(Long taskId, Long volunteerId, String status) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.status = status;
    }
}
