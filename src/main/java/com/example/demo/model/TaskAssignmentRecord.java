package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignment_records")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskRecord task;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    private VolunteerProfile volunteer;

    private LocalDateTime assignedAt;

    private String status; // ASSIGNED / IN_PROGRESS / COMPLETED / CANCELLED

    public TaskAssignmentRecord() {
        this.assignedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public TaskRecord getTask() {
        return task;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(TaskRecord task) {
        this.task = task;
    }

    public VolunteerProfile getVolunteer() {
        return volunteer;
    }
    
    public void setVolunteer(VolunteerProfile volunteer) {
        this.volunteer = volunteer;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
