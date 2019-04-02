package com.example.datingsite.service;

import com.example.datingsite.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDto);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllById();

    UserDTO updateUserById(Long id, UserDTO userToUpdate);

}
