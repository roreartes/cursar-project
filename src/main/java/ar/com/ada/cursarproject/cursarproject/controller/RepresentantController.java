package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.RepresentantDTO;
import ar.com.ada.cursarproject.cursarproject.services.RepresentantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/representants")
public class RepresentantController {

    @Autowired @Qualifier("representantService")
    private RepresentantService representantService;

    @PostMapping({"", "/"})
    public ResponseEntity addNewRepresentant(@Valid @RequestBody RepresentantDTO representantDTO){
        RepresentantDTO representantSaved = representantService.save(representantDTO);
        return ResponseEntity.ok(representantSaved);
    }
}
