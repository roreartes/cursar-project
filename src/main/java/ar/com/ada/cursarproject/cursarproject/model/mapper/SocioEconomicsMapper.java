package ar.com.ada.cursarproject.cursarproject.model.mapper;


import ar.com.ada.cursarproject.cursarproject.model.dto.SocioEconomicsDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.SocioEconomics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface SocioEconomicsMapper extends DataCyclerMapper<SocioEconomicsDTO, SocioEconomics> {
    SocioEconomicsMapper MAPPER = Mappers.getMapper(SocioEconomicsMapper.class);

}
