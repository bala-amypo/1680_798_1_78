package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerSkillRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int level;

    @ManyToOne
    private Volunteer volunteer;

    // Getters and Setters
}
