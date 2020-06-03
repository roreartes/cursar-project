package ar.com.ada.cursarproject.cursarproject.model.mapper;

import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends DataCyclerMapper<CompanyDTO, Company> {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);
}
