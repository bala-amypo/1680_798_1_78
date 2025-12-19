package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class VolunteerProfile {
@Id @GeneratedValue
private Long id;
@Column(unique = true)
private String volunteerId;
@Column(unique = true)
private String email;
@Column(unique = true)
private String phone;
private String fullName;
private String availabilityStatus;
private LocalDateTime createdAt = LocalDateTime.now();
// getters/setters
}