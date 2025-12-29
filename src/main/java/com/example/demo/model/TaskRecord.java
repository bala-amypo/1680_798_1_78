package com.example.demo.model;

public class TaskRecord {

    private Long id;
    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String status;

    // Default constructor
    public TaskRecord() {
        this.status = "OPEN"; // REQUIRED BY TEST
    }

    // Getters & Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
