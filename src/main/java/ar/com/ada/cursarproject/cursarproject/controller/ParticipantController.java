package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantDTO;
import ar.com.ada.cursarproject.cursarproject.services.ParticipantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    @Qualifier("participantService")
    private ParticipantService participantService;

    @PostMapping({"", "/"})
    private ResponseEntity addNewParticipant(@Valid @RequestBody ParticipantDTO participantDTO) throws URISyntaxException {
        ParticipantDTO participantSaved = participantService.save(participantDTO);

        return ResponseEntity.
                created(new URI("/participants/" + participantSaved.getId())).
                body(participantSaved);

    }


}
