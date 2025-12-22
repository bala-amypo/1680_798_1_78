package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private String requiredSkill;
    private int requiredSkillLevel;
    private String priority;
    private String status;

    public Long getId() { return id; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getRequiredSkill() { return requiredSkill; }
    public void setRequiredSkill(String requiredSkill) { this.requiredSkill = requiredSkill; }

    public int getRequiredSkillLevel() { return requiredSkillLevel; }
    public void setRequiredSkillLevel(int requiredSkillLevel) { this.requiredSkillLevel = requiredSkillLevel; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
