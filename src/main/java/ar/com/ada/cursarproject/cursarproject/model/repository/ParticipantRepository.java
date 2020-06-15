package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("participantRepository")
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
