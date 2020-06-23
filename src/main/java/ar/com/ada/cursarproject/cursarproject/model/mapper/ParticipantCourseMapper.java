package ar.com.ada.cursarproject.cursarproject.model.mapper;

import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantCourseDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.ParticipantCourse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantCourseMapper extends DataCyclerMapper<ParticipantCourseDTO, ParticipantCourse> {
    ParticipantCourseMapper MAPPER = Mappers.getMapper(ParticipantCourseMapper.class);
}
