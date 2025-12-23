package com.example.demo.service.impl;

import com.example.demo.dto.AssignmentStatusUpdateRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepo,
            VolunteerProfileRepository volunteerRepo,
            TaskRecordRepository taskRepo,
            VolunteerSkillRecordRepository skillRepo) {
        this.assignmentRepo = assignmentRepo;
        this.volunteerRepo = volunteerRepo;
        this.taskRepo = taskRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignVolunteerToTask(Long volunteerId, Long taskId) {

        if (assignmentRepo.existsByTask_IdAndStatus(taskId, "ASSIGNED")) {
            throw new BadRequestException("ACTIVE assignment already exists");
        }

        VolunteerProfile volunteer = volunteerRepo.findById(volunteerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));

        if (!"AVAILABLE".equals(volunteer.getAvailabilityStatus())) {
            throw new BadRequestException("Volunteer not available");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        List<VolunteerSkillRecord> skills =
                skillRepo.findByVolunteer_Id(volunteerId);

        boolean skillMatched = skills.stream()
                .anyMatch(skill ->
                        skill.getSkillName().equalsIgnoreCase(task.getRequiredSkill()) &&
                        SkillLevelUtil.meetsRequiredLevel(
                                skill.getSkillLevel(),
                                task.getRequiredLevel())
                );

        if (!skillMatched) {
            throw new BadRequestException("Insufficient skill level");
        }

        TaskAssignmentRecord assignment = new TaskAssignmentRecord();
        assignment.setVolunteer(volunteer);
        assignment.setTask(task);
        assignment.setStatus("ASSIGNED");

        task.setStatus("ASSIGNED");
        taskRepo.save(task);

        return assignmentRepo.save(assignment);
    }

    @Override
    public TaskAssignmentRecord updateAssignmentStatus(
            Long assignmentId,
            AssignmentStatusUpdateRequest request) {

        TaskAssignmentRecord assignment = assignmentRepo.findById(assignmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found"));

        assignment.setStatus(request.getStatus());
        return assignmentRepo.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsForVolunteer(Long volunteerId) {
        return assignmentRepo.findByVolunteer_Id(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsForTask(Long taskId) {
        return assignmentRepo.findByTask_Id(taskId);
    }
}
