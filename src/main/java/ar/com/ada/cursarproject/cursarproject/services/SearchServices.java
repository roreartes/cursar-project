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

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("courseCategoryRepository")
    private CourseCategoryRepository courseCategoryRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    public List<CoursesDTO> getAllCoursesAvailable() {
        List<Courses> allCourseAvailable = courseRepository.findAllCourseAvailable();
        List<CoursesDTO> allCourseDtoAvailable = courseMapper.toDto(allCourseAvailable, context);
        return allCourseDtoAvailable;
    }

    public List<CoursesDTO> getAllCoursesByCategory(Long categoryId) {
        courseCategoryRepository
                .findById(categoryId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("CourseCategory", categoryId));

        List<Courses> allCourseByCategory = courseRepository.findAllCourseByCategory(categoryId);
        List<CoursesDTO> allCourseByCategoryDTO = courseMapper.toDto(allCourseByCategory, context);
        return allCourseByCategoryDTO;
    }

    public List<CoursesDTO> getAllCoursesByCompany(Long companyId) {
        List<Courses> courseByCompany = courseRepository.findAllByCompany(companyId);
        List<CoursesDTO> courseByCompanyDTO = courseMapper.toDto(courseByCompany, context);
        return courseByCompanyDTO;
    }

    public List<CoursesDTO> getAllCoursesByCompanyAndCategory(Long companyId, Long categoryId) {
        List<Courses> coursesByCompanyAndCategory = courseRepository.findAllByCompanyAndCategory(companyId, categoryId);
        List<CoursesDTO> coursesByCompanyAndCategoryDTO = courseMapper.toDto(coursesByCompanyAndCategory, context);
        return coursesByCompanyAndCategoryDTO;
    }


    public List<CoursesDTO> getAllCoursesWithParticipantByStatusProgress(Long participantId, Boolean isFinish) {
        List<Courses> allCoursesByStatus = courseRepository.findAllCoursesByParticipansStatusProgress(isFinish);
        List<CoursesDTO> coursesByStatusDTOS = courseMapper.toDto(allCoursesByStatus, context);

        return coursesByStatusDTOS;
    }

}



