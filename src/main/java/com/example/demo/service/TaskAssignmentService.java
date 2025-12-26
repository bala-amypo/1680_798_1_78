package com.example.demo.service;

import com.example.demo.model.Task;
import java.util.List;

public interface TaskAssignmentService {

    Task assignTask(Long taskId);

    List<Task> getAllAssignments();

    List<Task> getAssignmentsByTask(Long taskId);

    List<Task> getAssignmentsByVolunteer(Long volunteerId);
}
