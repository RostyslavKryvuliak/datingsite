package com.example.datingsite.service.Impl;

import com.example.datingsite.config.jwt.JwtTokenProvider;
import com.example.datingsite.dto.Request.SigninRequest;
import com.example.datingsite.dto.Request.SignupRequest;
import com.example.datingsite.entity.RegistrationEntity;
import com.example.datingsite.entity.RoleEntity;
import com.example.datingsite.exeption.ExistsException;
import com.example.datingsite.exeption.NotFoundException;
import com.example.datingsite.repository.RegistrationRepository;
import com.example.datingsite.repository.RoleRepository;
import com.example.datingsite.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void registerRegistration(SignupRequest request) {

        if (registrationRepository.existsByEmailIgnoreCase(request.getEmail())){
            throw new ExistsException("User with email [" + request.getEmail() + "] already exist");
        }

        String login = request.getLogin();
        System.out.println("Login " + login);

        String  password = request.getPassword();
        System.out.println("Password " + password);

        String encPassword = passwordEncoder.encode(password);
        System.out.println("Enc Password " + encPassword);

        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setLogin(request.getLogin());
        registrationEntity.setPassword(request.getPassword());
        registrationEntity.setEmail(request.getEmail());

        RoleEntity roleEntity = roleRepository.findByRoleIgnoreCase("USER")
                .orElseThrow(() -> new NotFoundException("Role not found"));

        registrationEntity.setRoles(Arrays.asList(roleEntity));

        registrationRepository.save(registrationEntity);
    }

    @Override
    public String loginRegistration(SigninRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

}
