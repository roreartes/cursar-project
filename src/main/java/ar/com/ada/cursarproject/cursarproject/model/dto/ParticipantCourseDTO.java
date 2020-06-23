package ar.com.ada.cursarproject.cursarproject.model.dto;

import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class ParticipantCourseDTO implements Serializable {

    private Boolean isBuy;

    private Boolean hasApproved;

    private Integer percentage;

    private Boolean hasFinish;

    private Participant participant;

    private Courses courses;

}
