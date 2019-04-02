package com.example.datingsite.service.Impl;

import com.example.datingsite.dto.AdressDTO;
import com.example.datingsite.entity.AdressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datingsite.repository.AdressRepository;
import com.example.datingsite.service.AdressService;
import com.example.datingsite.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public AdressDTO saveAdress(AdressDTO adress) {

        AdressEntity adressEntity = modelMapper.map(adress, AdressEntity.class);

        adressRepository.save(adressEntity);
        return adress;

    }

    @Override
    public AdressDTO findAdressById(Long id) {

        AdressEntity adressEntity = adressRepository.findById(id).get();

        AdressDTO adressDTO = modelMapper.map(adressEntity, AdressDTO.class);

        return adressDTO;
    }

    @Override
    public List<AdressDTO> findAllById() {

        List<AdressEntity> adressEntities = adressRepository.findAll();

        List<AdressDTO> adressDTOS = modelMapper.mapAll(adressEntities, AdressDTO.class);

        return adressDTOS;
    }

    @Override
    public AdressDTO updateAdressById(Long id, AdressDTO adressToUpdate) {

        boolean exist = adressRepository.existsById(id);

        if(!exist) {
            return null;
        }

        AdressEntity adressFromDb = modelMapper.map(adressToUpdate, AdressEntity.class);
        adressFromDb.setId(adressToUpdate.getId());
        adressFromDb.setRegion(adressToUpdate.getRegion());
        adressFromDb.setCity(adressToUpdate.getCity());
        adressRepository.save(adressFromDb);
        return adressToUpdate;
    }

}
