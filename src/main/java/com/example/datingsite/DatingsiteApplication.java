package com.example.datingsite;

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
        SpringApplication.run(DatingsiteApplication.class, args); }

        @Autowired
        private RegistrationRepository registrationRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private RoleRepository roleRepository;

        public void run(String... args) throws Exception{

            if (roleRepository.count() == 0){
                RoleEntity roleAdmin = new RoleEntity();
                roleAdmin.setRole("ADMIN");

                RoleEntity roleUser = new RoleEntity();
                roleUser.setRole("USER");

                roleRepository.saveAll(Arrays.asList(roleAdmin, roleUser));
            }

            if (registrationRepository.count() == 0){

                RoleEntity roleAdmin = roleRepository.findByRoleIgnoreCase("ADMIN").get();
                RoleEntity roleUser = roleRepository.findByRoleIgnoreCase("USER").get();

                RegistrationEntity adminEntity = new RegistrationEntity();
                adminEntity.setLogin("Login" );
                adminEntity.setEmail("admin@gmail.com");
                adminEntity.setPassword(passwordEncoder.encode("123"));
                adminEntity.setRoles(Arrays.asList(roleAdmin));
                registrationRepository.save(adminEntity);

                for (int i = 0; i < 50; i++){
                    RegistrationEntity registrationEntity = new RegistrationEntity();
                    registrationEntity.setLogin("Login" + i);
                    registrationEntity.setEmail("user" + i + "@gmail.com");
                    registrationEntity.setPassword(passwordEncoder.encode("123"));
                    registrationEntity.setRoles(Arrays.asList(roleUser));
                    registrationRepository.save(registrationEntity);
                }
            }

        }

}
