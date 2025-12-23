package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRecordRepository extends JpaRepository<Task, Long> {
}
