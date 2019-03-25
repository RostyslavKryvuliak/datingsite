package service;

import dto.UserDTO;
import entity.UserEntity;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO user);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllById();

    UserDTO updateUserById(Long id, UserDTO userToUpdate);

}
