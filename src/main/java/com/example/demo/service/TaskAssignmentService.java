package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;

import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);

    List<TaskAssignmentRecord> getAllAssignments();
}















// package com.example.demo.service;

// import com.example.demo.dto.AssignmentStatusUpdateRequest;
// import com.example.demo.model.TaskAssignmentRecord;

// import java.util.List;

// public interface TaskAssignmentService {

//     TaskAssignmentRecord assignVolunteerToTask(Long volunteerId, Long taskId);

//     TaskAssignmentRecord updateAssignmentStatus(Long assignmentId,
//                                                 AssignmentStatusUpdateRequest request);

//     List<TaskAssignmentRecord> getAssignmentsForVolunteer(Long volunteerId);

//     List<TaskAssignmentRecord> getAssignmentsForTask(Long taskId);
// }
