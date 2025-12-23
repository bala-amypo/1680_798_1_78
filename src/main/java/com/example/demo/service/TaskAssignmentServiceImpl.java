package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.TaskAssignment;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private VolunteerProfileRepository volunteerProfileRepository;

    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    @Override
    public TaskAssignment autoAssignTask(Long taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Check if already assigned
        if (taskAssignmentRepository.existsByTaskIdAndStatus(
                String.valueOf(task.getId()), "ACTIVE")) {
            throw new RuntimeException("Task already assigned");
        }

        // Fetch available volunteers
        List<VolunteerProfile> volunteers =
                volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");

        // Find best-fit volunteer
        VolunteerProfile bestVolunteer = volunteers.stream()
                .filter(v ->
                        SkillLevelUtil.hasRequiredSkill(
                                v, task.getRequiredSkill(), task.getRequiredLevel()))
                .max(Comparator.comparingInt(
                        v -> SkillLevelUtil.getSkillLevel(v, task.getRequiredSkill())))
                .orElseThrow(() -> new RuntimeException("No suitable volunteer found"));

        // Create assignment
        TaskAssignment assignment = new TaskAssignment();
        assignment.setTaskId(String.valueOf(task.getId()));
        assignment.setVolunteerId(String.valueOf(bestVolunteer.getId()));
        assignment.setStatus("ACTIVE");

        return taskAssignmentRepository.save(assignment);
    }
}
