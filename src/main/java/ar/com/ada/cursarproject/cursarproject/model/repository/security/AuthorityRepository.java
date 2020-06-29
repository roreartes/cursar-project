package ar.com.ada.cursarproject.cursarproject.model.repository.security;

import ar.com.ada.cursarproject.cursarproject.model.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authorityRepository")
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
