@Entity
public class TaskAssignmentRecord {

    @Id @GeneratedValue
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status = "ACTIVE";
    private LocalDateTime assignedAt = LocalDateTime.now();
    private String notes;
}
