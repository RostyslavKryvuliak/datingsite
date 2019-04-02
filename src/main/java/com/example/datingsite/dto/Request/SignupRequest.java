package com.example.datingsite.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

}
