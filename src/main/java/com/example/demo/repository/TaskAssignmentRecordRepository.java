package com.example.demo.repository;

import com.example.demo.model.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignment, Long> {

    boolean existsByTaskIdAndStatus(String taskId, String status);
}
