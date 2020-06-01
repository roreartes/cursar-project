package ar.com.ada.cursarproject.cursarproject.model.mapper.circulardependency;

import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring")
public interface CompanyCycleMapper extends DataCycleMapper<CompanyDTO, Company> {
    CompanyCycleMapper MAPPER = Mappers.getMapper(CompanyCycleMapper.class);
}
