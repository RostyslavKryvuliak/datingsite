package com.example.datingsite.dto;

import com.example.datingsite.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class AdressDTO {

    private Long id;

    @NotBlank
    private String region;

    @NotBlank
    private String city;

    private List<UserEntity> users;
}
