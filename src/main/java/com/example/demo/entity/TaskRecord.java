package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status = "OPEN";

    private LocalDateTime createdAt = LocalDateTime.now();
}
