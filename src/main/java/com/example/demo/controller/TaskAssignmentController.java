package com.example.demo.controller;

import com.example.demo.service.TaskAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Assignments")
public class TaskAssignmentController {
    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/assign/{taskId}")
    public Object autoAssign(@PathVariable Long taskId) {
        return service.assignTask(taskId);
    }
}
