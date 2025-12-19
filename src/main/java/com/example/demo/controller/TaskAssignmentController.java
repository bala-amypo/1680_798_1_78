package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.impl.TaskAssignmentServiceImpl;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentServiceImpl service;

    public TaskAssignmentController(TaskAssignmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assign(@PathVariable Long taskId) {
        return service.assignTask(taskId);
    }
}
