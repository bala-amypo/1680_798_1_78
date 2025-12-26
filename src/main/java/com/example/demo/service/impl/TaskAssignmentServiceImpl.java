package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Task;
import com.example.demo.service.TaskAssignmentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    // For demonstration, using in-memory list. Replace with Repository in real app
    private List<Task> tasks = new ArrayList<>();

    @Override
    public Task assignTask(Long taskId) {
        // Simple demo logic: find task by id and mark as ASSIGNED
        for (Task t : tasks) {
            if (t.getId().equals(taskId)) {
                t.setStatus("ASSIGNED");
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Task> getAllAssignments() {
        return tasks;
    }

    @Override
    public List<Task> getAssignmentsByTask(Long taskId) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getId().equals(taskId)) result.add(t);
        }
        return result;
    }

    @Override
    public List<Task> getAssignmentsByVolunteer(Long volunteerId) {
        // Demo logic: returning all tasks (replace with real filter by volunteer)
        return tasks;
    }
}
