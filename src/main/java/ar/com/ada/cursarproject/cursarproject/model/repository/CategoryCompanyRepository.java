package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursAR.cursAR.model.entity.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryCompanyRepository extends JpaRepository<CompanyCategory, Long> {
}
