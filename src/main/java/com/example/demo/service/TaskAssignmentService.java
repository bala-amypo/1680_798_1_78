package com.example.demo.service;

import com.example.demo.model.Task;

public interface TaskAssignmentService {
    Task assignTaskToVolunteer(Long taskId);
}
