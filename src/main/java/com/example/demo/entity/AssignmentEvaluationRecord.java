@Entity
public class AssignmentEvaluationRecord {

    @Id @GeneratedValue
    private Long id;

    private Long assignmentId;
    private Integer rating;
    private String feedback;

    @PrePersist
    public void onEvaluate() {
        this.evaluatedAt = LocalDateTime.now();
    }
}
