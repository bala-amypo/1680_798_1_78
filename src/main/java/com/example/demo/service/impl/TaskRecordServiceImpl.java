package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

import java.util.List;
import java.util.Optional;

public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        task.setStatus("OPEN");
        return repository.save(task);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updated) {
        TaskRecord existing = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        existing.setTaskName(updated.getTaskName());
        existing.setRequiredSkill(updated.getRequiredSkill());
        existing.setRequiredSkillLevel(updated.getRequiredSkillLevel());

        return repository.save(existing);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }

    @Override
    public Optional<TaskRecord> getTaskByCode(String taskCode) {
        return repository.findByTaskCode(taskCode);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }
}





















// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.TaskRecord;
// import com.example.demo.repository.TaskRecordRepository;
// import com.example.demo.service.TaskRecordService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TaskRecordServiceImpl implements TaskRecordService {

//     private final TaskRecordRepository repository;

//     public TaskRecordServiceImpl(TaskRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public TaskRecord createTask(TaskRecord task) {

//         if (task.getStartDate() != null && task.getEndDate() != null &&
//             task.getStartDate().isAfter(task.getEndDate())) {
//             throw new BadRequestException("Start date cannot be after end date");
//         }

//         task.setStatus("OPEN");
//         return repository.save(task);
//     }

//     @Override
//     public TaskRecord getTask(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Task not found"));
//     }

//     @Override
//     public List<TaskRecord> getOpenTasks() {
//         return repository.findByStatus("OPEN");
//     }
// }
