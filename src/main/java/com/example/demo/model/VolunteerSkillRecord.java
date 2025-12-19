package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class VolunteerSkillRecord {
@Id @GeneratedValue
private Long id;
private Long volunteerId;
private String skillName;
private String skillLevel;
private Boolean certified;
private LocalDateTime updatedAt;


@PrePersist
void onCreate() { updatedAt = LocalDateTime.now(); }
}