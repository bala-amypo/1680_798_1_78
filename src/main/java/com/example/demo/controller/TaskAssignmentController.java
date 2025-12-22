package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Task Assignments", description = "Assign tasks to volunteers")
public class TaskAssignmentController {

    private final TaskAssignmentService assignmentService;

    public TaskAssignmentController(TaskAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assign/{taskId}")
    @Operation(summary = "Auto-assign a task to best-fit volunteer")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return assignmentService.assignTask(taskId);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update assignment status")
    public TaskAssignmentRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return assignmentService.updateAssignmentStatus(id, status);
    }

    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get assignments by volunteer")
    public List<TaskAssignmentRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return assignmentService.getAssignmentsByVolunteer(volunteerId);
    }

    @GetMapping("/task/{taskId}")
    @Operation(summary = "Get assignments by task")
    public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
        return assignmentService.getAssignmentsByTask(taskId);
    }

    @GetMapping
    @Operation(summary = "Get all assignments")
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }
}
