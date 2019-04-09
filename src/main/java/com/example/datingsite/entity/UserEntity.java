package com.example.datingsite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String firstname;

    @Column(nullable = false, length = 45)
    private String gender;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthDate;

    @OneToOne(mappedBy = "user")
    private AboutMeEntity aboutMe;

    @ManyToOne
    @JoinColumn(name = "adress_id")
    private AdressEntity adress;

}
