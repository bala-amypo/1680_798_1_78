package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Task;
import com.example.demo.service.TaskRecordService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    // In-memory list for demo. Replace with repository in real app
    private List<Task> tasks = new ArrayList<>();

    @Override
    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public Task getTaskById(Long id) {
        return tasks.stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
