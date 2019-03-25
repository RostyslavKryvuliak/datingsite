package service;

import dto.AboutMeDTO;

import java.util.List;

public interface AboutMeService {

    AboutMeDTO saveAbouMe(AboutMeDTO aboutMe);

    AboutMeDTO  findAbouMeById(Long id);

    List<AboutMeDTO > findAllById();

}
