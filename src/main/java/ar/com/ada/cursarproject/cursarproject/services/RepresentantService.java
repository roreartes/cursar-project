package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.RepresentantDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import ar.com.ada.cursarproject.cursarproject.model.entity.Representant;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.mapper.RepresentantMapper;
import ar.com.ada.cursarproject.cursarproject.model.repository.CompanyRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.RepresentantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("representantService")
public class RepresentantService implements Services<RepresentantDTO> {


    @Autowired @Qualifier("representantRepository")
    private RepresentantRepository representantRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private RepresentantMapper representantMapper = RepresentantMapper.MAPPER;

    @Override
    public List<RepresentantDTO> findAll() {
        return null;
    }

    @Override
    public RepresentantDTO save(RepresentantDTO dto) {

        Long CompanyId = dto.getCompany().getId();

        Company company;
        company = companyRepository.
                findById(CompanyId).
                orElseThrow((() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", CompanyId)));

        Representant representantToSave = representantMapper.toEntity(dto, context);

        representantToSave.setCompany(company);

        Representant representantSaved = representantRepository.save(representantToSave);

        RepresentantDTO representantDTOToSave = representantMapper.toDto(representantSaved, context);

        return representantDTOToSave;
    }

    @Override
    public void delete(Long id) {

    }
}
