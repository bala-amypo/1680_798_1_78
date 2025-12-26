package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Task;
import com.example.demo.service.TaskRecordService;

import java.util.List;

@RestController
@RequestMapping("/api/taskRecords")
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskRecordService.createTask(task);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRecordService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRecordService.getTaskById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRecordService.deleteTask(id);
    }
}
