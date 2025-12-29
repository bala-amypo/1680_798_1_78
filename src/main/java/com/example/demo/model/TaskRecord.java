package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "task_records",
        uniqueConstraints = @UniqueConstraint(columnNames = "taskCode")
)
@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskCode;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = TaskStatus.OPEN;
        }
    }
}

