package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.services.CoursesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    @Qualifier("coursesService")
    private CoursesService coursesService;

    @GetMapping({"", "/"})
    public ResponseEntity getAllCourses() {
        List<CoursesDTO> all = coursesService.findAll();
        return ResponseEntity.ok(all);
    }


    @PostMapping({"", "/"})
    public ResponseEntity addnewCourse(@Valid @RequestBody CoursesDTO coursesDTO) throws URISyntaxException {
        CoursesDTO courseSaved = coursesService.save(coursesDTO);

        return ResponseEntity.
                created(new URI("/courses/" + courseSaved.getId()))
                .body(courseSaved);

    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        coursesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
