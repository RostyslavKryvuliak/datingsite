package service.Impl;

import dto.UserDTO;
import entity.UserEntity;
import exeption.ExistsException;
import exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
import utils.ObjectMapperUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public UserDTO saveUser(UserDTO user) {

        boolean exists = userRepository.existsByFirstnameIgnoreCase(user.getFirstname());
        if (exists){
            throw new ExistsException("User wit name [ " + user.getFirstname() + " ] alredy exists");
        }

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userRepository.save(userEntity );
        return user;
    }

    @Override
    public UserDTO findUserById(Long id) {

        boolean exist = userRepository.existsById(id);
        if(!exist){
            throw new NotFoundException("User with id [" + id + "] not found");
        }

        UserEntity userEntity = userRepository.findById(id).get();

        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

      return userDTO;
    }

    @Override
    public List<UserDTO> findAllById() {
        List<UserEntity> userEntities = userRepository.findAll();

        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);

        return userDTOS;
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userToUpdate) {
        boolean exist = userRepository.existsById(id);

        if(!exist) {
            return null;
        }

        UserEntity userFromDb = userRepository.findById(id).get();
        userFromDb.setId(userToUpdate.getId());
        userFromDb.setFirstname(userToUpdate.getFirstname());
        userFromDb.setGender(userToUpdate.getGender());
        userFromDb.setBirthDate(userToUpdate.getBirthDate());
        userRepository.save(userFromDb);
        return null;
    }


}
