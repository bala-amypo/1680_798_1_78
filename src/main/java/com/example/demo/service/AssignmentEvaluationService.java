// AssignmentEvaluationService.java
package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {
    List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId);
}
