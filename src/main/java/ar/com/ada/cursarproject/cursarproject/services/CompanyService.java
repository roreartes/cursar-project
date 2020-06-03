package ar.com.ada.cursarproject.cursarproject.services;


import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import ar.com.ada.cursarproject.cursarproject.model.entity.CompanyCategory;

import ar.com.ada.cursarproject.cursarproject.model.mapper.CompanyMapper;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.repository.CategoryCompanyRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service("companyService")
public class CompanyService implements Services<CompanyDTO> {

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("categoryCompanyRepository")
    private CategoryCompanyRepository categoryCompanyRepository;

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyMapper companyMapper = CompanyMapper.MAPPER;

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> companyEntityList = companyRepository.findAll();
        List<CompanyDTO> companyDTOSList = companyMapper.toDto(companyEntityList, context);
        return companyDTOSList;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        // extraes el id para buscar la cat de la compañia
        Long categoryCompanyId = dto.getCompanyCategory().getId();

        // se busca la cate en la base de datos
        CompanyCategory categoryCompany = categoryCompanyRepository
                .findById(categoryCompanyId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("CategoryCompany", categoryCompanyId));

        // se convierte el dto a entity
        Company companyToSave = companyMapper.toEntity(dto, context);

        // antes de guardarlo, se debe settear la cat
        companyToSave.setCompanyCategory(categoryCompany);

        // seguarda en la base de datos
        Company companySaved = companyRepository.save(companyToSave);

        // se convierte en dto para entregarlo al controlador
        CompanyDTO companyDtoSaved = companyMapper.toDto(companySaved, context);

        return companyDtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
