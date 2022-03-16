package ru.itmo.inceptionservice.controller.dreams.stage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.controller.user.dto.PersonDataDTO;
import ru.itmo.inceptionservice.model.user.entity.PersonData;

@AllArgsConstructor
@Data
public class DreamStageParticipantDTO {
    private final PersonDataDTO personData;
    private final Boolean isMustAlive;
    private final String stageRole;
}
