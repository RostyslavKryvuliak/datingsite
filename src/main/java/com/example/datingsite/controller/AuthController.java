package com.example.datingsite.controller;

import com.example.datingsite.dto.Request.SigninRequest;
import com.example.datingsite.dto.Request.SignupRequest;
import com.example.datingsite.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("signup")
    public ResponseEntity registRegistration(@Valid @RequestBody SignupRequest request){
        authService.registerRegistration(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("signin")
    public ResponseEntity loginRegistration(@Valid @RequestBody SigninRequest request){
        String token = authService.loginRegistration(request);
        return new ResponseEntity(token, HttpStatus.OK);
    }

}
