package ar.com.ada.cursarproject.cursarproject.model.repository;


import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Courses, Long> {

}
