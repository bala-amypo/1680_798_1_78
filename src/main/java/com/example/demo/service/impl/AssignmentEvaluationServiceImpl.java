package com.example.demo.service.impl;

import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Override
    public void evaluateAssignment(Long assignmentId) {
        // stub implementation
        System.out.println("Evaluating assignment " + assignmentId);
    }
}
