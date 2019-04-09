package com.example.datingsite;

import com.example.datingsite.config.RunSecurityConfig;
import com.example.datingsite.entity.RegistrationEntity;
import com.example.datingsite.entity.RoleEntity;
import com.example.datingsite.repository.RegistrationRepository;
import com.example.datingsite.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DatingsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatingsiteApplication.class, args);

    }

}
