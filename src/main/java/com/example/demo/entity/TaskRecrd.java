@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "taskCode"))
public class TaskRecord {

    @Id @GeneratedValue
    private Long id;

    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status = "OPEN";

    private LocalDateTime createdAt = LocalDateTime.now();
}
