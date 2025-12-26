package com.example.demo.repository;

import com.example.demo.model.TaskRecord;

import java.util.List;
import java.util.Optional;

public interface TaskRecordRepository {

    TaskRecord save(TaskRecord task);

    Optional<TaskRecord> findById(Long id);

    Optional<TaskRecord> findByTaskCode(String taskCode);

    List<TaskRecord> findByStatus(String status);

    List<TaskRecord> findAll();
}






















// package com.example.demo.repository;

// import com.example.demo.model.TaskRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {

//     List<TaskRecord> findByStatus(String status);

//     List<TaskRecord> findByRequiredSkill(String requiredSkill);
// }
