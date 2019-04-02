package com.example.datingsite.service;

import com.example.datingsite.dto.Request.SigninRequest;
import com.example.datingsite.dto.Request.SignupRequest;

public interface AuthService {

    void registerRegistration(SignupRequest request);

    String loginRegistration(SigninRequest request);

}
