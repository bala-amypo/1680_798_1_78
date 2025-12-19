package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TaskRecord;
import java.util.*;

public interface TaskRecordRepository
        extends JpaRepository<TaskRecord, Long> {

    List<TaskRecord> findByStatus(String status);
    Optional<TaskRecord> findByTaskCode(String code);
}
