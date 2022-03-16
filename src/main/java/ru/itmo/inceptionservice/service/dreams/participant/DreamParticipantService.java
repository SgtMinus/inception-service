package ru.itmo.inceptionservice.service.dreams.participant;

import ru.itmo.inceptionservice.controller.dreams.stage.dto.DreamStageParticipantDTO;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;

import java.util.UUID;

public interface DreamParticipantService {
    DreamStageParticipant findByExternalId(UUID externalId);
    DreamStageParticipant createNew(DreamStageParticipantDTO dto);
}
