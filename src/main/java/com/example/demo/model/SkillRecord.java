package com.example.demo.model;

import java.time.LocalDateTime;

public class SkillRecord {

    private Long id;
    private String skillName;
    private String skillLevel;
    private LocalDateTime updatedAt;

    public SkillRecord() {
        this.updatedAt = LocalDateTime.now(); // REQUIRED BY TEST
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
