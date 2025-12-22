package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskAssignmentService {
    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    // Strict Constructor Injection Requirement
    public TaskAssignmentService(TaskAssignmentRecordRepository assignmentRepo, 
                                 TaskRecordRepository taskRepo, 
                                 VolunteerProfileRepository volunteerRepo, 
                                 VolunteerSkillRecordRepository skillRepo) {
        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
        this.skillRepo = skillRepo;
    }

    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment exists");
        }

        List<VolunteerProfile> volunteers = volunteerRepo.findByAvailabilityStatus("AVAILABLE");
        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        int reqLevel = SkillLevelUtil.levelRank(task.getRequiredSkillLevel());

        VolunteerProfile bestMatch = volunteers.stream()
            .filter(v -> skillRepo.findByVolunteerId(v.getId()).stream()
                .anyMatch(s -> s.getSkillName().equalsIgnoreCase(task.getRequiredSkill()) 
                          && SkillLevelUtil.levelRank(s.getSkillLevel()) >= reqLevel))
            .findFirst()
            .orElseThrow(() -> new BadRequestException("No volunteer meets required skill level"));

        TaskAssignmentRecord record = new TaskAssignmentRecord();
        record.setTaskId(taskId);
        record.setVolunteerId(bestMatch.getId());
        record.setStatus("ACTIVE");
        record.setAssignedAt(LocalDateTime.now());
        
        return assignmentRepo.save(record);
    }
}
