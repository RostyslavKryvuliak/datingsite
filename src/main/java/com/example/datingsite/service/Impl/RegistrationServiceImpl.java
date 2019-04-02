package com.example.datingsite.service.Impl;

import com.example.datingsite.dto.RegistrationDTO;
import com.example.datingsite.entity.RegistrationEntity;
import com.example.datingsite.exeption.ExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datingsite.repository.RegistrationRepository;
import com.example.datingsite.service.RegistrationService;
import com.example.datingsite.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private RegistrationRepository registrationRepository;


    @Override
    public RegistrationDTO saveRegistration(RegistrationDTO regis) {

        boolean exists = registrationRepository.existsByLoginIgnoreCase(regis.getLogin());
        if (exists){
            throw new ExistsException("User with login [ " + regis.getLogin() + " ] alredy exists");
        }

        boolean exists2 = registrationRepository.existsByEmailIgnoreCase(regis.getEmail());
        if (exists2){
            throw new ExistsException("User with email [ " + regis.getEmail() + " ] alredy exists");
        }


        RegistrationEntity registrationEntity = modelMapper.map(regis, RegistrationEntity.class);

        registrationRepository.save(registrationEntity);
        return regis;
    }

    @Override
    public RegistrationDTO findRegistrationById(Long id) {

        RegistrationEntity registrationEntity = registrationRepository.findById(id).get();

        RegistrationDTO registrationDTO = modelMapper.map(registrationEntity, RegistrationDTO.class);

        return registrationDTO;
    }

    @Override
    public List<RegistrationDTO> findAllById() {
        List<RegistrationEntity> registrationEntities = registrationRepository.findAll();

        List<RegistrationDTO> registrationDTOS = modelMapper.mapAll(registrationEntities, RegistrationDTO.class);

        return registrationDTOS;
    }

    @Override
    public RegistrationDTO updateRegistById(Long id, RegistrationDTO registToUpdate) {

        boolean exist = registrationRepository.existsById(id);

        if(!exist) {
            return null;
        }

        RegistrationEntity registFromDb = modelMapper.map(registToUpdate, RegistrationEntity.class);
        registFromDb.setId(registToUpdate.getId());
        registFromDb.setLogin(registFromDb.getLogin());
        registFromDb.setPassword(registFromDb.getPassword());
        registFromDb.setEmail(registFromDb.getEmail());
        registrationRepository.save(registFromDb);
        return registToUpdate;

    }
}
