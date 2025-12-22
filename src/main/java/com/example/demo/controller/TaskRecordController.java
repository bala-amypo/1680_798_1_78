package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Manage tasks")
public class TaskRecordController {

    private final TaskRecordService taskService;

    public TaskRecordController(TaskRecordService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Create a new task")
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task")
    public TaskRecord updateTask(@PathVariable Long id, @RequestBody TaskRecord updated) {
        return taskService.updateTask(id, updated);
    }

    @GetMapping("/open")
    @Operation(summary = "Get all open tasks")
    public List<TaskRecord> getOpenTasks() {
        return taskService.getOpenTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return taskService.getTaskByCode(String.valueOf(id));
    }

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<TaskRecord> getAllTasks() {
        return taskService.getAllTasks();
    }
}
