package com.example.datingsite.dto;

import com.example.datingsite.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AboutMeDTO {

    private Long id;

    @NotBlank
    private String height;

    @NotBlank
    private String weight;

    @NotBlank
    private String physique;

    @NotBlank
    private String whyYouEnter;

    @NotBlank
    private String aboutYourself;

    private UserEntity user;

}
