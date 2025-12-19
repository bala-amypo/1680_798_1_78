package com.example.demo.service;


import java.util.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;


@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {


private final TaskAssignmentRecordRepository assignmentRepo;
private final TaskRecordRepository taskRepo;
private final VolunteerProfileRepository volunteerRepo;
private final VolunteerSkillRecordRepository skillRepo;


public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository a, TaskRecordRepository t,
VolunteerProfileRepository v, VolunteerSkillRecordRepository s) {
this.assignmentRepo = a; this.taskRepo = t; this.volunteerRepo = v; this.skillRepo = s;
}


public TaskAssignmentRecord assignTask(Long taskId) {
TaskRecord task = taskRepo.findById(taskId)
.orElseThrow(() -> new BadRequestException("Task not found"));


if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE"))
throw new BadRequestException("ACTIVE assignment");


List<VolunteerProfile> volunteers = volunteerRepo.findByAvailabilityStatus("AVAILABLE");
if (volunteers.isEmpty()) throw new BadRequestException("No AVAILABLE volunteers");


VolunteerProfile best = null;
int bestRank = 0;


for (VolunteerProfile v : volunteers) {
for (VolunteerSkillRecord s : skillRepo.findByVolunteerId(v.getId())) {
if (s.getSkillName().equals(task.getRequiredSkill())) {
int rank = SkillLevelUtil.levelRank(s.getSkillLevel());
if (rank >= SkillLevelUtil.levelRank(task.getRequiredSkillLevel()) && rank > bestRank) {
best = v; bestRank = rank;
}
}
}
}


if (best == null) throw new BadRequestException("required skill level");


TaskAssignmentRecord ar = new TaskAssignmentRecord();
ar.setTaskId(taskId);
ar.setVolunteerId(best.getId());
return assignmentRepo.save(ar);
}
}