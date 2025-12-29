package com.example.demo.model;

public class AssignmentRecord {

    private Long id;
    private Long taskId;
    private Long volunteerId;
    private String status;

  public AssignmentRecord() {
    this.status = "ACTIVE";
}


    public String getStatus() {
        return status;
    }
}
