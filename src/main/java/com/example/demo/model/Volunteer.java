package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    // Getters and Setters
}
