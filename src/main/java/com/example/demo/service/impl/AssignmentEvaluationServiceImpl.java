package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

import java.util.List;

public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repository;

    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return repository.findByAssignmentId(assignmentId);
    }
}





















// package com.example.demo.service.impl;

// import com.example.demo.dto.EvaluationRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.repository.AssignmentEvaluationRecordRepository;
// import com.example.demo.repository.TaskAssignmentRecordRepository;
// import com.example.demo.service.AssignmentEvaluationService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AssignmentEvaluationServiceImpl
//         implements AssignmentEvaluationService {

//     private final AssignmentEvaluationRecordRepository evaluationRepo;
//     private final TaskAssignmentRecordRepository assignmentRepo;

//     public AssignmentEvaluationServiceImpl(
//             AssignmentEvaluationRecordRepository evaluationRepo,
//             TaskAssignmentRecordRepository assignmentRepo) {
//         this.evaluationRepo = evaluationRepo;
//         this.assignmentRepo = assignmentRepo;
//     }

//     @Override
//     public AssignmentEvaluationRecord evaluateAssignment(
//             Long assignmentId,
//             EvaluationRequest request) {

//         TaskAssignmentRecord assignment = assignmentRepo.findById(assignmentId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Assignment not found"));

//         if (!"COMPLETED".equals(assignment.getStatus())) {
//             throw new BadRequestException(
//                     "Assignment must be COMPLETED before evaluation");
//         }

//         AssignmentEvaluationRecord evaluation =
//                 new AssignmentEvaluationRecord();

//         evaluation.setAssignment(assignment);
//         evaluation.setRating(request.getRating());
//         evaluation.setFeedback(request.getFeedback());

//         return evaluationRepo.save(evaluation);
//     }

//     @Override
//     public List<AssignmentEvaluationRecord>
//     getEvaluationsForVolunteer(Long volunteerId) {

//         return evaluationRepo
//                 .findByAssignment_Volunteer_Id(volunteerId);
//     }
// }
