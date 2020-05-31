package ar.com.ada.cursarproject.cursarproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, length = 40)
    private String modality;

    @Column(nullable = false, length = 10)
    private Integer cost;

    @Column(nullable = false, length = 10)
    private Integer courseHours;

    @Column(nullable = false, length = 3)
    private Integer quota;

    @Column(nullable = false, length = 3)
    private Integer scholarship;

    @ManyToOne
    @JoinColumn(name = "Company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "CourseCategory_id")
    private CourseCategory courseCategory;

   /* @ManyToMany
    @JoinTable(name = "Participants_has_Courses",
            joinColumns = @JoinColumn(name = "Courses_id"),
    inverseJoinColumns = @JoinColumn(name = "Participant_id"))*/

    @OneToMany(mappedBy = "courses")
    private Set<ParticipantCourse> participantCourses;


}
