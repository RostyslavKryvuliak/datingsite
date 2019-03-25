package dto;

import entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class AdressDTO {

    private Long id;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    private List<UserEntity> users;
}
