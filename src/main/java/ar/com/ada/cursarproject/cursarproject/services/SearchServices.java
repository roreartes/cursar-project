package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CourseMapper;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseCategoryRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchServices")
public class SearchServices {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("courseCategoryRepository")
    private CourseCategoryRepository courseCategoryRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    public List<CoursesDTO> getAllCourseAvailable() {
        List<Courses> allCourseAvailable = courseRepository.findAllCourseAvailable();
        List<CoursesDTO> allCourseDtoAvailable = courseMapper.toDto(allCourseAvailable, context);
        return allCourseDtoAvailable;
    }

    public List<CoursesDTO> getAllCourseByCategory(Long categoryId) {
        courseCategoryRepository
                .findById(categoryId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("CourseCategory", categoryId));

        List<Courses> allCourseByCategory = courseRepository.findAllCourseByCategory(categoryId);
        List<CoursesDTO> allCourseByCategoryDTO = courseMapper.toDto(allCourseByCategory, context);
        return allCourseByCategoryDTO;
    }
}
