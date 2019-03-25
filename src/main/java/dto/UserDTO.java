package dto;

import entity.AboutMeEntity;
import entity.AdressEntity;
import entity.RegistrationEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
