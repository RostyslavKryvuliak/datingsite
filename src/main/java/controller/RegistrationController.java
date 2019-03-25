package controller;

import dto.RegistrationDTO;
import dto.UserDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RegistrationService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("regist")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/save")
    public ResponseEntity saveRegist(@Valid @RequestBody RegistrationDTO registrationDTO){

        RegistrationDTO savedRegist = registrationService.saveRegistration(registrationDTO);
        return ResponseEntity.ok(savedRegist);
    }

}
