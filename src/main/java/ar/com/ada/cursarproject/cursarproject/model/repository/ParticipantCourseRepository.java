package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.ParticipantCourse;
import ar.com.ada.cursarproject.cursarproject.model.entity.ParticipantCourseID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("participantCourseRepository")
public interface ParticipantCourseRepository extends JpaRepository<ParticipantCourse, ParticipantCourseID> {
}
