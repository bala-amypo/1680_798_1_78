package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;

import java.util.List;

public interface AssignmentEvaluationService {

    AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord record);

    List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId);
}

















// package com.example.demo.service;

// import com.example.demo.dto.EvaluationRequest;
// import com.example.demo.model.AssignmentEvaluationRecord;

// import java.util.List;

// public interface AssignmentEvaluationService {

//     AssignmentEvaluationRecord evaluateAssignment(Long assignmentId,
//                                                   EvaluationRequest request);

//     List<AssignmentEvaluationRecord> getEvaluationsForVolunteer(Long volunteerId);
// }
