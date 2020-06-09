package ar.com.ada.cursarproject.cursarproject.controller;


import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    @Qualifier("coursesService")
    private CoursesService coursesService;

    @PostMapping({"", "/"})
    public ResponseEntity addnewCourse(@Valid @RequestBody CoursesDTO coursesDTO){
        CoursesDTO courseSaved = coursesService.save(coursesDTO);

        return ResponseEntity.ok(courseSaved);

    }


}

