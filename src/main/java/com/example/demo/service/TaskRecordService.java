package com.example.demo.service;

import com.example.demo.model.Task;
import java.util.List;

public interface TaskRecordService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void deleteTask(Long id);
}
