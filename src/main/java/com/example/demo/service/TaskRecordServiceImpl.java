package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import java.util.List;

public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        return repository.save(task);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updated) {
        TaskRecord task = repository.findById(id).orElseThrow();
        task.setTaskName(updated.getTaskName());
        task.setRequiredSkill(updated.getRequiredSkill());
        task.setRequiredSkillLevel(updated.getRequiredSkillLevel());
        task.setPriority(updated.getPriority());
        task.setStatus(updated.getStatus());
        return repository.save(task);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }

    @Override
    public TaskRecord getTaskByCode(String code) {
        return repository.findByTaskCode(code);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }
}
