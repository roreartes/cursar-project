package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import ar.com.ada.cursarproject.cursarproject.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired @Qualifier("companyService")
    private CompanyService companyService;

    @GetMapping({"", "/"})
    public ResponseEntity getAllCompanies(){
        List<CompanyDTO> allCompanies = companyService.findAll();
        return ResponseEntity.ok(allCompanies);
    }


    @PostMapping({"", "/"})
    public ResponseEntity addNewCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        CompanyDTO companySaved = companyService.save(companyDTO);
        return ResponseEntity.ok(companySaved);
    }

}
