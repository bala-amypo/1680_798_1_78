package com.example.demo.repository;

import com.example.demo.model.TaskAssignmentRecord;

import java.util.List;
import java.util.Optional;

public interface TaskAssignmentRecordRepository {

    TaskAssignmentRecord save(TaskAssignmentRecord record);

    Optional<TaskAssignmentRecord> findById(Long id);

    boolean existsByTaskIdAndStatus(Long taskId, String status);

    List<TaskAssignmentRecord> findByTaskId(Long taskId);

    List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);

    List<TaskAssignmentRecord> findAll();
}


















// package com.example.demo.repository;

// import com.example.demo.model.TaskAssignmentRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface TaskAssignmentRecordRepository
//         extends JpaRepository<TaskAssignmentRecord, Long> {

//     boolean existsByTask_IdAndStatus(Long taskId, String status);

//     List<TaskAssignmentRecord> findByVolunteer_Id(Long volunteerId);

//     List<TaskAssignmentRecord> findByTask_Id(Long taskId);
// }
