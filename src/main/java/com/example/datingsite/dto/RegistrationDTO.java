package com.example.datingsite.dto;

import com.example.datingsite.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class RegistrationDTO {

    private Long id;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    private UserEntity user;

}
