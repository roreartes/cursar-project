package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantCourseDTO;
import ar.com.ada.cursarproject.cursarproject.services.ParticipantCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/participantCourse")
public class ParticipantCourseController {

    @Autowired
    @Qualifier("participantCourseService")
    private ParticipantCourseService participantCourseService;

    @PostMapping({"/courses/{courseId}/participant/{participantId}", "/courses/{courseId}/participant/{participantId}/"})
    private ResponseEntity addNewCourseApplication(@Valid @RequestBody ParticipantCourseDTO participantCourseDTO,
                                                   @PathVariable Long courseId, @PathVariable Long partipantId) throws URISyntaxException {
        ParticipantCourseDTO courseApplicationSaved = participantCourseService.courseApplication(
                participantCourseDTO, courseId, partipantId);

        return ResponseEntity.created(new URI("/participantCourse" + courseApplicationSaved)). //completar
                body(courseApplicationSaved);
    }

}
