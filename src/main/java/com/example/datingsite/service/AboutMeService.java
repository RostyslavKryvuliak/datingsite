package com.example.datingsite.service;

import com.example.datingsite.dto.AboutMeDTO;

import java.util.List;

public interface AboutMeService {

    AboutMeDTO saveAbouMe(AboutMeDTO aboutMe);

    AboutMeDTO findAbouMeById(Long id);

    List<AboutMeDTO> findAll();

    AboutMeDTO updateAboutMeById(Long id, AboutMeDTO aboutMeToUpdate);

}
