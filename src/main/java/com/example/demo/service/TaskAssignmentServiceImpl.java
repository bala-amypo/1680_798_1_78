TaskAssignment assignment = new TaskAssignment();
assignment.setVolunteerId(String.valueOf(v.getId()));
assignment.setTaskId(String.valueOf(task.getId()));
assignment.setStatus("ACTIVE");

taskAssignmentRepository.save(assignment);
