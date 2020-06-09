package ar.com.ada.cursarproject.cursarproject.model.mapper;


import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper extends DataCyclerMapper<CoursesDTO, Courses> {
    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);
}