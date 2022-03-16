package ru.itmo.inceptionservice.service.dreams.stage.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.AddNewStageDTO;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;
import ru.itmo.inceptionservice.model.user.entity.User;
import ru.itmo.inceptionservice.service.dreams.participant.DreamParticipantService;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DreamStageFactory {

    private final DreamParticipantService dreamParticipantService;

    public DreamStage create(User arch, AddNewStageDTO dto){
        return DreamStage.builder()
                .stageNumber(dto.getStageNumber())
                .description(dto.getDescription())
                .architect(arch)
                .externalId(UUID.randomUUID())
                .participants(
                        dto.getNewParticipants()
                                .stream()
                                .map(dreamParticipantService::createNew)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
