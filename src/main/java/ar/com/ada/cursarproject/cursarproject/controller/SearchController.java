package ar.com.ada.cursarproject.cursarproject.controller;

import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.services.SearchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired @Qualifier("searchServices")
    private SearchServices searchServices;

    @GetMapping({"/courses/available", "/courses/available/"})
    public ResponseEntity getAllCourses() {
        List<CoursesDTO> allCourseAvailable = searchServices.getAllCoursesAvailable();
        return ResponseEntity.ok(allCourseAvailable);
    }

    // localhost:8080/search/courses/category/1
    @GetMapping({"/courses/category/{categoryId}", "/courses/category/{categoryId}/"})
    public ResponseEntity getAllCoursesByCategory(@PathVariable Long categoryId) {
        List<CoursesDTO> allCourseAvailable = searchServices.getAllCoursesByCategory(categoryId);
        return ResponseEntity.ok(allCourseAvailable);
    }

@GetMapping({"/courses/company/{companyId}\", \"/courses/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompany(@PathVariable Long companyId){
    List<CoursesDTO> allCoursesByCompany = searchServices.getAllCoursesByCompany(companyId);
    return ResponseEntity.ok(allCoursesByCompany);
    }

    @GetMapping({"/courses/category/{categoryId}/company/{companyId}",
            "/courses/category/{categoryId}/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompanyAndCategory( @PathVariable Long companyId,
                                                             @PathVariable Long categoryId){
        List<CoursesDTO> coursesByCompanyAndCategory = searchServices.getAllCoursesByCompanyAndCategory(companyId, categoryId);
        return ResponseEntity.ok(coursesByCompanyAndCategory);
    }

    @GetMapping({"/courses/participant/in-progress/{hasFinish}"})
    public ResponseEntity getAllCoursesByParticipantStatus ( @PathVariable Long participantId, @PathVariable Boolean isFinish){
        List<CoursesDTO> allCoursesByStatus = searchServices.getAllCoursesWithParticipantByStatusProgress(participantId, isFinish);
        return ResponseEntity.ok(allCoursesByStatus);
    }


    // "/courses/category/{categoryId}/company/{companyId}"
}
