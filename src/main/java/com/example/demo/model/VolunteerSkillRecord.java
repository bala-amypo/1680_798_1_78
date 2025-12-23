package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "volunteer_skill_records",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"volunteer_id", "skillName"}
    )
)
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    private Integer skillLevel; // numeric (1–5)

    private Integer yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    private VolunteerProfile volunteer;

    public VolunteerSkillRecord() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }
    
    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public VolunteerProfile getVolunteer() {
        return volunteer;
    }
    
    public void setVolunteer(VolunteerProfile volunteer) {
        this.volunteer = volunteer;
    }
}
