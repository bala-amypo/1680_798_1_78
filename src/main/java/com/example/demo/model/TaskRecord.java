package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String taskCode;

    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status = "OPEN";

    private LocalDateTime createdAt = LocalDateTime.now();
}
