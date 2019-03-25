package service.Impl;

import dto.RegistrationDTO;
import entity.RegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RegistrationRepository;
import service.RegistrationService;
import utils.ObjectMapperUtils;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private RegistrationRepository registrationRepository;


    @Override
    public RegistrationDTO saveRegistration(RegistrationDTO regis) {

        RegistrationEntity registrationEntity = modelMapper.map(regis, RegistrationEntity.class);
        registrationEntity.setId(regis.getId());

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
}
