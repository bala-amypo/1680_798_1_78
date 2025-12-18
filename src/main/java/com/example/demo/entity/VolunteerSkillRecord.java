@Entity
public class VolunteerSkillRecord {

    @Id @GeneratedValue
    private Long id;

    private Long volunteerId;
    private String skillName;
    private String skillLevel;
    private Boolean certified;

    @PrePersist
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
