package controller;

import dto.AdressDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AdressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping("/save")
    public ResponseEntity saveAdress(@Valid @RequestBody AdressDTO adressDTO){

        AdressDTO savedAdress = adressService.saveAdress(adressDTO);
        return ResponseEntity.ok(savedAdress);
    }

    @GetMapping("{adressId}")
    public ResponseEntity<?> getAdressById(@PathVariable("adressId") Long id) {
        AdressDTO adressDTO = adressService.findAdressById(id);
        return new ResponseEntity<>(adressDTO, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AdressDTO>> getAllAdress(){
        List<AdressDTO> adress = adressService.findAllById();
        return  new ResponseEntity<>(adress, HttpStatus.OK);
    }

    @PutMapping("{adressd}")
    public ResponseEntity<?> updateAdress(
            @PathVariable("adressId") Long id,
            @RequestBody AdressDTO adressDTO
    ) {
        AdressDTO adressDTO1 = adressService.updateAdressById(id, adressDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
