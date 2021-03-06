package com.example.datingsite.controller;

import com.example.datingsite.dto.RegistrationDTO;
import com.example.datingsite.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("regist")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/save")
    public ResponseEntity saveRegist(@Valid @RequestBody RegistrationDTO registrationDTO) {

        RegistrationDTO savedRegist = registrationService.saveRegistration(registrationDTO);
        return ResponseEntity.ok(savedRegist);
    }

    @GetMapping("{registId}")
    public ResponseEntity<?> getRegstById(@PathVariable("registId") Long id) {
        RegistrationDTO registrationDTO = registrationService.findRegistrationById(id);
        return new ResponseEntity<>(registrationDTO, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> getAllRegist() {
        List<RegistrationDTO> regists = registrationService.findAll();
        return new ResponseEntity<>(regists, HttpStatus.OK);
    }

    @PutMapping("{rehistId}")
    public ResponseEntity<?> updateRegistration(
            @PathVariable("registId") Long id,
            @RequestBody RegistrationDTO registrationDTO
    ) {
        RegistrationDTO registrationDTO1 = registrationService.updateRegistById(id, registrationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
