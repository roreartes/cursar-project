package ar.com.ada.cursarproject.cursarproject.model.repository;


import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
