@Entity
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volunteerld;
    private String skillName;
    private int skillLevel;

    public String getSkillName() { return skillName; }
    public int getSkillLevel() { return skillLevel; }
}
