package ar.com.ada.cursarproject.cursarproject.model.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class ParticipantCourseID implements Serializable {

    @Column(name = "Participant_id")
    private Long participantId;


    @Column(name = "Courses_id")
    private Long coursesId;


    public ParticipantCourseID setParticipantId(Long participantId){
        this.participantId = participantId;

        return this;
    }

    public ParticipantCourseID setCoursesId(Long coursesId){
        this.coursesId = coursesId;
        return this;
    }
}
