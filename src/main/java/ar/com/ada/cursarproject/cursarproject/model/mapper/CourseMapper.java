package ar.com.ada.cursarproject.cursarproject.model.mapper;

import ar.com.ada.cursarproject.cursarproject.model.dto.CoursesDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper extends DataCyclerMapper<CoursesDTO, Courses> {
    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "companyId", ignore = true)
    CoursesDTO toDto(Courses entity, @Context CycleAvoidingMappingContext context);
}