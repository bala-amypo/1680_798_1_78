package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.Volunteer;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    boolean assignTaskToVolunteer(Long taskId);
}
