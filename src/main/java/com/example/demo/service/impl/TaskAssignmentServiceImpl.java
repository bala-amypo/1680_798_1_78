package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository volunteerRepo,
            VolunteerSkillRecordRepository skillRepo) {

        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment already exists");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        List<VolunteerProfile> volunteers =
                volunteerRepo.findByAvailabilityStatus("AVAILABLE");

        for (VolunteerProfile v : volunteers) {
            List<VolunteerSkillRecord> skills =
                    skillRepo.findByVolunteerId(v.getId());

            for (VolunteerSkillRecord s : skills) {
                if (s.getSkillName().equalsIgnoreCase(task.getRequiredSkill())
                        && SkillLevelUtil.meetsRequiredLevel(
                        s.getSkillLevel(), task.getRequiredSkillLevel())) {

                    task.setStatus("ACTIVE");
                    taskRepo.save(task);

                    return assignmentRepo.save(
                            new TaskAssignmentRecord(taskId, v.getId(), "ACTIVE"));
                }
            }
        }

        throw new BadRequestException("No volunteer meets required skill level");
    }
}
