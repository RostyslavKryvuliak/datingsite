package com.example.datingsite.controller;

import com.example.datingsite.dto.AdressDTO;
import com.example.datingsite.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping("/save")
    public ResponseEntity saveAdress(@Valid @RequestBody AdressDTO adressDTO) {

        AdressDTO savedAdress = adressService.saveAdress(adressDTO);
        return ResponseEntity.ok(savedAdress);
    }

    @GetMapping("{adressId}")
    public ResponseEntity<?> getAdressById(@PathVariable("adressId") Long id) {
        AdressDTO adressDTO = adressService.findAdressById(id);
        return new ResponseEntity<>(adressDTO, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AdressDTO>> getAllAdress() {
        List<AdressDTO> adress = adressService.findAll();
        return new ResponseEntity<>(adress, HttpStatus.OK);
    }

    @PutMapping("{addressId}")
    public ResponseEntity<?> updateAdress(
            @PathVariable("addressId") Long id,
            @RequestBody AdressDTO adressDTO
    ) {
        AdressDTO adressDTO1 = adressService.updateAdressById(id, adressDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
