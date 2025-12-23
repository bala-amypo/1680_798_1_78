package com.example.demo.service;

import com.example.demo.model.TaskRecord;

import java.util.List;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    TaskRecord getTask(Long id);

    List<TaskRecord> getOpenTasks();
}
