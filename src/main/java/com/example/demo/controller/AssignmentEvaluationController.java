package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Evaluations", description = "Submit and view assignment evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evalService;

    public AssignmentEvaluationController(AssignmentEvaluationService evalService) {
        this.evalService = evalService;
    }

    @PostMapping
    @Operation(summary = "Submit an evaluation")
    public AssignmentEvaluationRecord submitEvaluation(@RequestBody AssignmentEvaluationRecord evaluation) {
        return evalService.evaluateAssignment(evaluation);
    }

    @GetMapping("/assignment/{assignmentId}")
    @Operation(summary = "Get evaluations for an assignment")
    public List<AssignmentEvaluationRecord> getByAssignment(@PathVariable Long assignmentId) {
        return evalService.getEvaluationsByAssignment(assignmentId);
    }

    @GetMapping
    @Operation(summary = "Get all evaluations")
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return evalService.getAllEvaluations();
    }
}
