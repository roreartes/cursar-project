package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursAR.cursAR.model.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
