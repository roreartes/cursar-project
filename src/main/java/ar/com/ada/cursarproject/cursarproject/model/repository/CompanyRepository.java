package ar.com.ada.cursarproject.cursarproject.model.repository;


import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
