// AssignmentEvaluationController.java
package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @GetMapping("/evaluate/{id}")
    public List<AssignmentEvaluationRecord> evaluate(@PathVariable Long id) {
        return assignmentEvaluationService.getEvaluationsByAssignment(id);
    }
}
