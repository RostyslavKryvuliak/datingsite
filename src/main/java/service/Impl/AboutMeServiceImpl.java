package service.Impl;

import dto.AboutMeDTO;
import entity.AboutMeEntity;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AboutMeRepository;
import service.AboutMeService;
import utils.ObjectMapperUtils;

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

        AboutMeEntity aboutMeFromDb = aboutMeRepository.findById(id).get();
        aboutMeFromDb.setId(aboutMeToUpdate.getId());
        aboutMeFromDb.setHeight(aboutMeToUpdate.getHeight());
        aboutMeFromDb.setWeight(aboutMeToUpdate.getWeight());
        aboutMeFromDb.setPhysique(aboutMeToUpdate.getPhysique());
        aboutMeFromDb.setWhyYouEnter(aboutMeToUpdate.getWhyYouEnter());
        aboutMeFromDb.setAboutYourself(aboutMeToUpdate.getAboutYourself());
        aboutMeRepository.save(aboutMeFromDb);
        return null;
    }

}
