package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Task;
import com.example.demo.service.TaskAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService service;

    @PostMapping("/assign/{taskId}")
    public Task assignTask(@PathVariable Long taskId) {
        return service.assignTask(taskId);
    }

    @GetMapping("/all")
    public List<Task> getAllAssignments() {
        return service.getAllAssignments();
    }

    @GetMapping("/byTask/{taskId}")
    public List<Task> getAssignmentsByTask(@PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    @GetMapping("/byVolunteer/{volunteerId}")
    public List<Task> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }
}
