package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantCourseDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Courses;
import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import ar.com.ada.cursarproject.cursarproject.model.entity.ParticipantCourse;
import ar.com.ada.cursarproject.cursarproject.model.entity.ParticipantCourseID;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.mapper.ParticipantCourseMapper;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.ParticipantCourseRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("participantCourseService")
public class ParticipantCourseService {

    ParticipantCourseMapper participantCourseMapper = ParticipantCourseMapper.MAPPER;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("participantCourseRepository")
    private ParticipantCourseRepository participantCourseRepository;


    public ParticipantCourseDTO courseApplication(ParticipantCourseDTO dto, Long participantId, Long courseId) {
        Participant participant = participantRepository
                .findById(participantId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", participantId));

        Courses course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("", courseId));

        ParticipantCourseDTO courseApplication = dto.getIsBuy() ?
                this.saveCourseApplicationByPurchase(participant, course) :
                this.saveCourseApplicationByScholarship(participant, course);

//        if (dto.getIsBuy()) {
//            courseApplication = this.saveCourseApplicationByPurchase(participant, course);
//        } else {
//            courseApplication = this.saveCourseApplicationByScholarship(participant, course);
//        }

        return courseApplication;
    }

    public ParticipantCourseDTO saveCourseApplicationByPurchase(Participant participant, Courses course) {
        ParticipantCourseDTO courseApplicationByPurchase;
        if (course.getCounterBuy() > 0) {

            ParticipantCourseID id = new ParticipantCourseID();
            id.setCoursesId(course.getId());
            id.setParticipantId(participant.getId());

            ParticipantCourse participantCourseToSave = new ParticipantCourse();
            participantCourseToSave.setId(id);
            participantCourseToSave.setIsBuy(true); // false
            participantCourseToSave.setHasApproved(true); // null o no se hace
            participantCourseToSave.setPercentage(0); // no se hace
            participantCourseToSave.setHasFinished(false);

            ParticipantCourse participantCourseSaved = participantCourseRepository.save(participantCourseToSave);

            int counterBuy = course.getCounterBuy() - 1;
            course.setCounterBuy(counterBuy);
            courseRepository.save(course);

            courseApplicationByPurchase = participantCourseMapper.toDto(participantCourseSaved, context);
        } else {
            throw logicExceptionComponent.throwExceptionCourseSoldOut(course.getName());
        }
        return courseApplicationByPurchase;
    }

    public ParticipantCourseDTO saveCourseApplicationByScholarship(Participant participant, Courses course) {


        ParticipantCourseID id = new ParticipantCourseID();
        id.setCoursesId(course.getId());
        id.setParticipantId(participant.getId());

        ParticipantCourse participantCourseToSave = new ParticipantCourse();
        participantCourseToSave.setId(id);
        participantCourseToSave.setIsBuy(false);
        participantCourseToSave.setHasApproved(null);
        participantCourseToSave.setHasFinished(false);

        ParticipantCourse participantCourseSaved = participantCourseRepository.save(participantCourseToSave);

        ParticipantCourseDTO courseApplicationByScholarship =
                participantCourseMapper.toDto(participantCourseSaved, context);


        return courseApplicationByScholarship;
    }
}
