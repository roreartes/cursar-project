package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.SocioEconomicsDTO;
import ar.com.ada.cursarproject.cursarproject.services.SocioEconomicsService;
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
@RequestMapping("/socioEconomics")
public class SocioEconomicsController {

    @Autowired @Qualifier("socioEconomicsService")
    private SocioEconomicsService socioEconomicsService;

    @PostMapping({"", "/"})
    private ResponseEntity addNewSocioEconomics(@Valid @RequestBody SocioEconomicsDTO socioEconomicsDTO)throws URISyntaxException {
        SocioEconomicsDTO socioEconomicsSaved = socioEconomicsService.save(socioEconomicsDTO);
        return ResponseEntity.
                created(new URI ("/socioEconomics/" + socioEconomicsSaved.getId())).
                body(socioEconomicsSaved);
    }
}
