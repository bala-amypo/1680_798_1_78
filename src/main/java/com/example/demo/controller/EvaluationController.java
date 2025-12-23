package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public EvaluationController(
            AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @PostMapping("/{assignmentId}")
    public ResponseEntity<AssignmentEvaluationRecord> evaluate(
            @PathVariable Long assignmentId,
            @RequestBody EvaluationRequest request) {
        return ResponseEntity.ok(
                assignmentEvaluationService.evaluateAssignment(assignmentId, request)
        );
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getEvaluationsForVolunteer(
            @PathVariable Long volunteerId) {
        return ResponseEntity.ok(
                assignmentEvaluationService.getEvaluationsForVolunteer(volunteerId)
        );
    }
}
