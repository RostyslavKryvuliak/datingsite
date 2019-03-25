package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String login;

    @Column(nullable = false,unique = true, length = 45)
    private String password;

    @Column(nullable = false,unique = true, length = 45)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
