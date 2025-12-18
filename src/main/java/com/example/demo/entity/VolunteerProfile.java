@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "volunteerId"),
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "phone")
})
public class VolunteerProfile {

    @Id @GeneratedValue
    private Long id;
    
    private String volunteerId;
    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;

    private LocalDateTime createdAt = LocalDateTime.now();
}
