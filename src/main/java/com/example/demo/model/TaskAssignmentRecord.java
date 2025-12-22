@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private String volunteerld;
    private String status;

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
