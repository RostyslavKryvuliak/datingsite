package com.example.datingsite.service;

import com.example.datingsite.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {

    RegistrationDTO saveRegistration(RegistrationDTO regis);

    RegistrationDTO findRegistrationById(Long id);

    List<RegistrationDTO> findAll();

    RegistrationDTO updateRegistById(Long id, RegistrationDTO registToUpdate);

}
