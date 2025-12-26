package com.example.demo.controller;

import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @PostMapping("/evaluate/{id}")
    public String evaluate(@PathVariable Long id) {
        assignmentEvaluationService.evaluateAssignment(id);
        return "Assignment " + id + " evaluated.";
    }
}
