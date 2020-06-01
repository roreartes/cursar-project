package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.model.dto.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyService implements Services<CompanyDTO> {
    @Override
    public List<CompanyDTO> findAll() {
        return null;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
