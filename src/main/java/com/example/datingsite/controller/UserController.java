package com.example.datingsite.controller;

import com.example.datingsite.dto.UserDTO;
import com.example.datingsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@Valid @RequestBody UserDTO userDTO) {

        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long id) {
        UserDTO userDTO = userService.findUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

    @PutMapping("{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable("userId") Long id,
            @RequestBody UserDTO userDTO
    ) {
        UserDTO userDTO1 = userService.updateUserById(id, userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
