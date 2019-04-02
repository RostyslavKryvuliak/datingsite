package com.example.datingsite.service.Impl;

import com.example.datingsite.dto.AboutMeDTO;
import com.example.datingsite.entity.AboutMeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datingsite.repository.AboutMeRepository;
import com.example.datingsite.service.AboutMeService;
import com.example.datingsite.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class AboutMeServiceImpl implements AboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public AboutMeDTO saveAbouMe(AboutMeDTO aboutMe) {

        AboutMeEntity aboutMeEntity = modelMapper.map(aboutMe, AboutMeEntity.class);

        aboutMeRepository.save(aboutMeEntity);
        return aboutMe;
    }

    @Override
    public AboutMeDTO findAbouMeById(Long id) {

        AboutMeEntity aboutMeEntity = aboutMeRepository.findById(id).get();

        AboutMeDTO aboutMeDTO = modelMapper.map(aboutMeEntity, AboutMeDTO.class);

        return aboutMeDTO;
    }

    @Override
    public List<AboutMeDTO> findAllById() {

        List<AboutMeEntity> aboutMeEntities = aboutMeRepository.findAll();

        List<AboutMeDTO> aboutMeDTOS = modelMapper.mapAll(aboutMeEntities, AboutMeDTO.class);

        return aboutMeDTOS;
    }

    @Override
    public AboutMeDTO updateAboutMeById(Long id, AboutMeDTO aboutMeToUpdate) {

        boolean exist = aboutMeRepository.existsById(id);

        if (!exist) {
            return null;
        }

        AboutMeEntity aboutMeFromDb = modelMapper.map(aboutMeToUpdate, AboutMeEntity.class);
        aboutMeFromDb.setId(aboutMeToUpdate.getId());
        aboutMeFromDb.setHeight(aboutMeToUpdate.getHeight());
        aboutMeFromDb.setWeight(aboutMeToUpdate.getWeight());
        aboutMeFromDb.setPhysique(aboutMeToUpdate.getPhysique());
        aboutMeFromDb.setWhyYouEnter(aboutMeToUpdate.getWhyYouEnter());
        aboutMeFromDb.setAboutYourself(aboutMeToUpdate.getAboutYourself());
        aboutMeRepository.save(aboutMeFromDb);
        return aboutMeToUpdate;
    }

}
