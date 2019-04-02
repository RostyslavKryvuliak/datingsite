package com.example.datingsite.service;

import com.example.datingsite.dto.AdressDTO;

import java.util.List;

public interface AdressService {

    AdressDTO saveAdress(AdressDTO adress);

    AdressDTO findAdressById(Long id);

    List<AdressDTO> findAllById();

    AdressDTO updateAdressById(Long id, AdressDTO adressToUpdate);

}
