package service;

import dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {

    RegistrationDTO saveRegistration(RegistrationDTO regis);

    RegistrationDTO findRegistrationById (Long id);

    List<RegistrationDTO> findAllById();

}
