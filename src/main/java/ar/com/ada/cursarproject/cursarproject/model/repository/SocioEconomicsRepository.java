package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.SocioEconomics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("socioEconomicsRepository")
public interface SocioEconomicsRepository extends JpaRepository<SocioEconomics, Long> {

}
