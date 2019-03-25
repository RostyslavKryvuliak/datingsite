package controller;

import dto.AboutMeDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AboutMeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("aboutMe")
public class AboutMeController {

    @Autowired
    private AboutMeService aboutMeService;

    @PostMapping("/save")
    public ResponseEntity saveAboutMe(@Valid @RequestBody AboutMeDTO aboutMeDTO){

        AboutMeDTO savedAboutMe = aboutMeService.saveAbouMe(aboutMeDTO);
        return ResponseEntity.ok(savedAboutMe);
    }

    @GetMapping("{aboutMeId}")
    public ResponseEntity<?> getAboutMeById(@PathVariable("aboutMeId") Long id) {
        AboutMeDTO aboutMeDTO = aboutMeService.findAbouMeById(id);
        return new ResponseEntity<>(aboutMeDTO, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AboutMeDTO>> getAllAboutMe(){
        List<AboutMeDTO> aboutMe = aboutMeService.findAllById();
        return  new ResponseEntity<>(aboutMe, HttpStatus.OK);
    }

    @PutMapping("{aboutMeId}")
    public ResponseEntity<?> updateAboutMe(
            @PathVariable("aboutMeId") Long id,
            @RequestBody AboutMeDTO aboutMeDTO
    ) {
        AboutMeDTO aboutMeDTO1 = aboutMeService.updateAboutMeById(id, aboutMeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
