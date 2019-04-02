package com.example.datingsite.dto;

import com.example.datingsite.entity.AboutMeEntity;
import com.example.datingsite.entity.AdressEntity;
import com.example.datingsite.entity.RegistrationEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {


    private Long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String gender;

    @NotBlank
    private Date birthDate;

    private RegistrationEntity registration;

    private AboutMeEntity aboutMe;

    private AdressEntity adress;

}
