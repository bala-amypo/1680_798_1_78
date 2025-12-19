package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignmentRecord, Long> {

    boolean existsByTaskIdAndStatus(Long id, String status);
    List<TaskAssignmentRecord> findByTaskId(Long id);
    List<TaskAssignmentRecord> findByVolunteerId(Long id);
}
