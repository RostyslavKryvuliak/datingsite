package service.Impl;

import dto.AdressDTO;
import entity.AdressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdressRepository;
import service.AdressService;
import utils.ObjectMapperUtils;

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

        AdressEntity adressFromDb = adressRepository.findById(id).get();
        adressFromDb.setId(adressToUpdate.getId());
        adressFromDb.setCountry(adressToUpdate.getCountry());
        adressFromDb.setCity(adressToUpdate.getCity());
        adressRepository.save(adressFromDb);
        return null;
    }

}
