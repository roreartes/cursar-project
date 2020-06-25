package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Courses, Long> {

    @Query(value = "SELECT * FROM Courses WHERE counterBuy > 0 OR counterScholarship > O", nativeQuery = true)
    List<Courses> findAllCourseAvailable();

    @Query(value = "SELECT * FROM Courses WHERE CourseCategory_id = :categoryId", nativeQuery = true)
    List<Courses> findAllCourseByCategory(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM Course AS c WHERE c.companyId = :companyId", nativeQuery = true)
    List<Courses> findAllByCompany(@Param("company") Long companyId);

 /*   @Query(value = "SELECT * FROM Course AS co WHERE co.companyId = :companyId AND c = c.categoryId")
    List<Courses> findAllByCompanyAndCategory(@Param("companyId") Long companyId, @Param("categoryId") Long categoryId);*/
}
