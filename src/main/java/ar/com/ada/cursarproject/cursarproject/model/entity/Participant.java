package ar.com.ada.cursarproject.cursarproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, length = 20)
    private String gender;

    @Column(nullable = false, length = 50)
    private String address;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private SocioEconomics socioEconomics;

    @OneToMany(mappedBy = "participant")
    private Set<ParticipantCourse> participantCourses;



}
