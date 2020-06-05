package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.Representant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("representantService")
public interface RepresentantRepository extends JpaRepository<Representant, Long> {

}
