package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.Volunteer;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.VolunteerRepository;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public Task createTask(Task task) {
        task.setStatus("OPEN"); // default status
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public boolean assignTaskToVolunteer(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if ("ACTIVE".equals(task.getStatus())) {
            return false; // Already assigned
        }

        // Get available volunteers
        List<Volunteer> availableVolunteers = volunteerRepository.findByAvailabilityStatus(true);

        // Filter volunteers with required skill level
        List<Volunteer> suitableVolunteers = availableVolunteers.stream()
                .filter(v -> SkillLevelUtil.hasRequiredSkillLevel(v, task.getRequiredSkill(), task.getRequiredLevel()))
                .collect(Collectors.toList());

        if (suitableVolunteers.isEmpty()) return false;

        // Choose the best-fit volunteer (highest skill)
        Volunteer bestVolunteer = suitableVolunteers.stream()
                .max(Comparator.comparingInt(v -> SkillLevelUtil.getSkillLevel(v, task.getRequiredSkill())))
                .get();

        // Assign task
        task.setAssignedVolunteer(bestVolunteer);
        task.setStatus("ACTIVE");
        taskRepository.save(task);

        return true;
    }
}
