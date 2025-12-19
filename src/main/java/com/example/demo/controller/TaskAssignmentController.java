package com.example.demo.controller;


import com.example.demo.service.TaskAssignmentService;
import com.example.demo.model.TaskAssignmentRecord;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Task Assignments")
public class TaskAssignmentController {
private final TaskAssignmentService service;


public TaskAssignmentController(TaskAssignmentService service) {
this.service = service;
}


@PostMapping("/assign/{taskId}")
public TaskAssignmentRecord assign(@PathVariable Long taskId) {
return service.assignTask(taskId);
}
}