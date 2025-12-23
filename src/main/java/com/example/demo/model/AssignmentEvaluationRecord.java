package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_evaluation_records")
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private TaskAssignmentRecord assignment;

    private Integer rating;

    private String feedback;

    private LocalDateTime evaluatedAt;

    public AssignmentEvaluationRecord() {
        this.evaluatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public TaskAssignmentRecord getAssignment() {
        return assignment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssignment(TaskAssignmentRecord assignment) {
        this.assignment = assignment;
    }

    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
