package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_records")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String status; // OPEN / ACTIVE

    public TaskRecord() {}

    public Long getId() { return id; }
    public String getRequiredSkill() { return requiredSkill; }
    public String getRequiredSkillLevel() { return requiredSkillLevel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
