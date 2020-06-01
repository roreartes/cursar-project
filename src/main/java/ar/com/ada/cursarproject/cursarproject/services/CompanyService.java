package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import ar.com.ada.cursarproject.cursarproject.model.mapper.circulardependency.CompanyCycleMapper;
import ar.com.ada.cursarproject.cursarproject.model.mapper.circulardependency.CycleAvoidingmappingContext;
import ar.com.ada.cursarproject.cursarproject.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyService implements Services<CompanyDTO> {
    @Autowired
    @Qualifier("actorRepository")
    private CompanyRepository companyRepository;

    private CompanyCycleMapper companyCycleMapper = CompanyCycleMapper.MAPPER;

    private CycleAvoidingmappingContext context = CycleAvoidingmappingContext.getInstance();

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> companyEntityList = companyRepository.findAll();
        List<CompanyDTO> companyDTOSList = companyCycleMapper.toDto(companyEntityList, context);
        return companyDTOSList;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        Company companyToSave = companyCycleMapper.toEntity(dto, context);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDTO companyDtoSaved = companyCycleMapper.toDto(companySaved, context);
        return companyDtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
