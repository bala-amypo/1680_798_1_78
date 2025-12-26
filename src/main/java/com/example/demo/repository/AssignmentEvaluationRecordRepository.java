package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;

import java.util.List;

public interface AssignmentEvaluationRecordRepository {

    AssignmentEvaluationRecord save(AssignmentEvaluationRecord record);

    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}

























// package com.example.demo.repository;

// import com.example.demo.model.AssignmentEvaluationRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface AssignmentEvaluationRecordRepository
//         extends JpaRepository<AssignmentEvaluationRecord, Long> {

//     List<AssignmentEvaluationRecord>
//     findByAssignment_Volunteer_Id(Long volunteerId);
// }
