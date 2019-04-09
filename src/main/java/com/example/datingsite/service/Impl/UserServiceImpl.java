package com.example.datingsite.service.Impl;

import com.example.datingsite.dto.UserDTO;
import com.example.datingsite.entity.UserEntity;
import com.example.datingsite.exception.NotFoundException;
import com.example.datingsite.repository.UserRepository;
import com.example.datingsite.service.UserService;
import com.example.datingsite.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public UserDTO saveUser(UserDTO user) {

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserDTO findUserById(Long id) {

        boolean exist = userRepository.existsById(id);
        if (!exist) {
            throw new NotFoundException("User with id [" + id + "] not found");
        }

        UserEntity userEntity = userRepository.findById(id).get();

        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {

        List<UserEntity> userEntities = userRepository.findAll();

        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);

        return userDTOS;

    }


    @Override
    public UserDTO updateUserById(Long id, UserDTO userToUpdate) {
        boolean exist = userRepository.existsById(id);

        if (!exist) {
            return null;
        }

        UserEntity userFromDb = modelMapper.map(userToUpdate, UserEntity.class);
        userFromDb.setFirstname(userToUpdate.getFirstname());
        userFromDb.setGender(userToUpdate.getGender());
        userFromDb.setBirthDate(userToUpdate.getBirthDate());
        userRepository.save(userFromDb);
        return userToUpdate;
    }


}
