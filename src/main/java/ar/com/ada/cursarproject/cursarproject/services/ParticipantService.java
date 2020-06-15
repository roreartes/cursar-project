package ar.com.ada.cursarproject.cursarproject.services;

import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.ParticipantDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.mapper.ParticipantMapper;
import ar.com.ada.cursarproject.cursarproject.model.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class ParticipantService implements Services<ParticipantDTO> {

    @Autowired
    @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private ParticipantMapper participantMapper = ParticipantMapper.MAPPER;




    @Override
    public ParticipantDTO save(ParticipantDTO dto) {
        Participant participantToSave = participantMapper.toEntity(dto, context);
        Participant participantSaved = participantRepository.save(participantToSave);
        ParticipantDTO participantDtoSaved = participantMapper.toDto(participantSaved, context);

        return participantDtoSaved;
    }


    @Override
    public List<ParticipantDTO> findAll() {
        return null;
    }


    @Override
    public void delete(Long id) {

    }
}
