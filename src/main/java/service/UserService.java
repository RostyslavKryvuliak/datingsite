package service;

import dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDto);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllById();

    UserDTO updateUserById(Long id, UserDTO userToUpdate);

}
