package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aboutMe")
public class AboutMeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String height;

    @Column(nullable = false, length = 45)
    private String weight;

    @Column(nullable = false, length = 45)
    private String physique;

    @Column(nullable = false, length = 80)
    private String whyYouEnter;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String aboutYourself;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
