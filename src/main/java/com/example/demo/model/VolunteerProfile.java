package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String availabilityStatus;

    @OneToOne
    private Volunteer volunteer;

    // Getters and Setters
}
