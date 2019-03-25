package service;

import dto.AdressDTO;

import java.util.List;

public interface AdressService {

    AdressDTO saveAdress(AdressDTO adress);

    AdressDTO findAdressById(Long id);

    List<AdressDTO> findAllById();

}
