package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.SkillLevelUtil;
import com.example.demo.exception.BadRequestException;

@Service
public class TaskAssignmentServiceImpl {

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

    public TaskAssignmentRecord assignTask(Long taskId) {

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment");
        }

        List<VolunteerProfile> volunteers =
                volunteerRepo.findByAvailabilityStatus("AVAILABLE");

        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        for (VolunteerProfile v : volunteers) {
            for (VolunteerSkillRecord s : skillRepo.findByVolunteerId(v.getId())) {
                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                        SkillLevelUtil.levelRank(s.getSkillLevel())
                        >= SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord record = new TaskAssignmentRecord();
                    record.setTaskId(taskId);
                    record.setVolunteerId(v.getId());
                    return assignmentRepo.save(record);
                }
            }
        }
        throw new BadRequestException("required skill level");
    }
}
