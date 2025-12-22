package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer_skill_records")
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volunteerId;
    private String skillName;
    private String skillLevel; // BEGINNER / INTERMEDIATE / EXPERT

    public VolunteerSkillRecord() {}

    public VolunteerSkillRecord(Long volunteerId, String skillName, String skillLevel) {
        this.volunteerId = volunteerId;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }

    public String getSkillName() { return skillName; }
    public String getSkillLevel() { return skillLevel; }
}
