package ru.itmo.inceptionservice.controller.dreams.stage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class AddNewStageDTO {
    private final Long stageNumber;
    private final String description;
    private final List<DreamStageParticipantDTO> newParticipants;
}
