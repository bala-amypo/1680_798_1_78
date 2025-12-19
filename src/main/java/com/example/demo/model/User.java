@Entity
public class User {

    @Id @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;
}
