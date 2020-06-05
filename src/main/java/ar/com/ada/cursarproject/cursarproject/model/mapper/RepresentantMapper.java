package ar.com.ada.cursarproject.cursarproject.model.mapper;

import ar.com.ada.cursarproject.cursarproject.model.dto.RepresentantDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Representant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RepresentantMapper extends DataCyclerMapper<RepresentantDTO, Representant> {
    RepresentantMapper MAPPER = Mappers.getMapper(RepresentantMapper.class);
}
