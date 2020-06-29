package ar.com.ada.cursarproject.cursarproject.model.repository.security;

import ar.com.ada.cursarproject.cursarproject.model.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}