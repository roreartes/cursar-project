package ar.com.ada.cursarproject.cursarproject.model.mapper;

import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantMapper extends DataCyclerMapper<ParticipantDTO, Participant> {
    ParticipantMapper MAPPER = Mappers.getMapper(ParticipantMapper.class);

}
