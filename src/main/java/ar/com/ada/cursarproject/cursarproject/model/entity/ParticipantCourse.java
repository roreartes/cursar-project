package ar.com.ada.cursarproject.cursarproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Participants_has_Courses")
public class ParticipantCourse {

    @EmbeddedId
    private ParticipantCourseID id;

    @ManyToOne
    @MapsId("participantId")
    private Participant participant;

    @ManyToOne
    @MapsId("coursesId")
    private Courses courses;

    @Column(nullable = false)
    private Boolean isBuy;

    @Column(nullable = false)
    private Boolean hasApproved;

    @Column(nullable = false)
    private Integer percentage;

    @Column(nullable = false)
    private Boolean hasFinished;
}
