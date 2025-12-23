package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRecordService taskRecordService;

    public TaskController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping
    public ResponseEntity<TaskRecord> createTask(
            @RequestBody TaskRecord task) {
        return ResponseEntity.ok(
                taskRecordService.createTask(task)
        );
    }

    @GetMapping("/open")
    public ResponseEntity<List<TaskRecord>> getOpenTasks() {
        return ResponseEntity.ok(
                taskRecordService.getOpenTasks()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(
                taskRecordService.getTask(id)
        );
    }
}
