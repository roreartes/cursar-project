package ar.com.ada.cursarproject.cursarproject.services;


import ar.com.ada.cursarproject.cursarproject.component.BusinessLogicExceptionComponent;
import ar.com.ada.cursarproject.cursarproject.model.dto.SocioEconomicsDTO;
import ar.com.ada.cursarproject.cursarproject.model.entity.Participant;
import ar.com.ada.cursarproject.cursarproject.model.entity.SocioEconomics;
import ar.com.ada.cursarproject.cursarproject.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.cursarproject.cursarproject.model.mapper.SocioEconomicsMapper;
import ar.com.ada.cursarproject.cursarproject.model.repository.ParticipantRepository;
import ar.com.ada.cursarproject.cursarproject.model.repository.SocioEconomicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socioEconomicsService")
public class SocioEconomicsService implements Services<SocioEconomicsDTO> {

    @Autowired
    @Qualifier("socioEconomicsRepository")
    private SocioEconomicsRepository socioEconomicsRepository;

    @Autowired
    @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private SocioEconomicsMapper socioEconomicsMapper = SocioEconomicsMapper.MAPPER;

    @Override
    public List<SocioEconomicsDTO> findAll() {
        return null;
    }

    @Override
    public SocioEconomicsDTO save(SocioEconomicsDTO dto) {
        Long participantId = dto.getParticipantId();

        Participant participant =  participantRepository.findById(participantId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", participantId));

        SocioEconomics socioEconomicsToSave = socioEconomicsMapper.toEntity(dto, context);

        socioEconomicsToSave.setParticipant(participant);

        SocioEconomics socioEconomicsSaved = socioEconomicsRepository.save(socioEconomicsToSave);

        SocioEconomicsDTO socioEconomicsDTOSaved = socioEconomicsMapper.toDto(socioEconomicsSaved, context);

        return socioEconomicsDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
