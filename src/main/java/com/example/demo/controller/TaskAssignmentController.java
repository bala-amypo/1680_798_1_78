package com.example.demo.controller;

import com.example.demo.dto.AssignmentStatusUpdateRequest;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping("/{volunteerId}/{taskId}")
    public ResponseEntity<TaskAssignmentRecord> assignVolunteer(
            @PathVariable Long volunteerId,
            @PathVariable Long taskId) {
        return ResponseEntity.ok(
                taskAssignmentService.assignVolunteerToTask(volunteerId, taskId)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskAssignmentRecord> updateStatus(
            @PathVariable Long id,
            @RequestBody AssignmentStatusUpdateRequest request) {
        return ResponseEntity.ok(
                taskAssignmentService.updateAssignmentStatus(id, request)
        );
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsForVolunteer(
            @PathVariable Long volunteerId) {
        return ResponseEntity.ok(
                taskAssignmentService.getAssignmentsForVolunteer(volunteerId)
        );
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsForTask(
            @PathVariable Long taskId) {
        return ResponseEntity.ok(
                taskAssignmentService.getAssignmentsForTask(taskId)
        );
    }
}
