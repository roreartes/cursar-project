package ar.com.ada.cursarproject.cursarproject.services;


import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import ar.com.ada.cursarproject.cursarproject.model.entity.CourseCategory;
import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CourseMapper;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.repository.CompanyRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseCategoryRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("coursesService")
public class CoursesService implements Services<CoursesDTO> {

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("courseCategoryRepository")
    private CourseCategoryRepository courseCategoryRepository;

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Override
    public List<CoursesDTO> findAll() {
        List<Courses> coursesEntityList = courseRepository.findAll();
        List<CoursesDTO> coursesDtosList = courseMapper.toDto(coursesEntityList, context);
        return coursesDtosList;
    }

    @Override
    public CoursesDTO save(CoursesDTO dto) {
        Long courseCategoryId = dto.getCourseCategory().getId();
        Long companyId = dto.getCompanyId();


        CourseCategory courseCategory;
        courseCategory = courseCategoryRepository.findById(courseCategoryId).
                orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("CourseCategory", courseCategoryId));

        Company company;
        company = companyRepository.findById(companyId).
                orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));

        Courses coursesToSave = courseMapper.toEntity(dto, context);

        coursesToSave.setCompany(company);
        coursesToSave.setCourseCategory(courseCategory);

        Courses coursesSaved = courseRepository.save(coursesToSave);

        CoursesDTO coursesDtoSaved = courseMapper.toDto(coursesSaved, context);


        return coursesDtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}

