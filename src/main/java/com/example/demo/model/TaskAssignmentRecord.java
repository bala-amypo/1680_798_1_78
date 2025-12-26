package com.example.demo.model;

public class TaskAssignmentRecord {

    private Long id;
    private Long taskId;
    private Long volunteerId;
    private String status = "ACTIVE";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}














































// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "task_assignment_records")
// public class TaskAssignmentRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "task_id", nullable = false)
//     private TaskRecord task;

//     @ManyToOne
//     @JoinColumn(name = "volunteer_id", nullable = false)
//     private VolunteerProfile volunteer;

//     private LocalDateTime assignedAt;

//     private String status; // ASSIGNED / IN_PROGRESS / COMPLETED / CANCELLED

//     public TaskAssignmentRecord() {
//         this.assignedAt = LocalDateTime.now();
//     }

//     // Getters and Setters

//     public Long getId() {
//         return id;
//     }

//     public TaskRecord getTask() {
//         return task;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setTask(TaskRecord task) {
//         this.task = task;
//     }

//     public VolunteerProfile getVolunteer() {
//         return volunteer;
//     }
    
//     public void setVolunteer(VolunteerProfile volunteer) {
//         this.volunteer = volunteer;
//     }

//     public LocalDateTime getAssignedAt() {
//         return assignedAt;
//     }

//     public String getStatus() {
//         return status;
//     }
    
//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
