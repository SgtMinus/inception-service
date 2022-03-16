package ru.itmo.inceptionservice.service.dreams.participant;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.DreamStageParticipantDTO;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.dreams.participant.repository.DreamStageParticipantRepository;
import ru.itmo.inceptionservice.service.dreams.participant.factory.DreamStageParticipantFactory;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class DreamParticipantServiceImpl implements DreamParticipantService {

    private final DreamStageParticipantRepository participantRepository;
    private final DreamStageParticipantFactory participantFactory;

    @Override
    public DreamStageParticipant findByExternalId(UUID externalId) {
        return participantRepository
                .findByExternalId(externalId)
                .orElseThrow();
    }

    @Override
    public DreamStageParticipant createNew(DreamStageParticipantDTO dto) {
        return participantRepository.saveAndFlush(participantFactory.create(dto));
    }
}
