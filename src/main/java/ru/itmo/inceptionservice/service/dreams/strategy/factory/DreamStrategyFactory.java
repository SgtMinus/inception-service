package ru.itmo.inceptionservice.service.dreams.strategy.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.controller.dreams.strategy.dto.AddNewStrategyDTO;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;
import ru.itmo.inceptionservice.service.dreams.stage.DreamStageService;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DreamStrategyFactory {

    private final DreamStageService stageService;

    public DreamStrategy create(AddNewStrategyDTO dto){
        return new DreamStrategy().builder()
                .externalId(UUID.randomUUID())
                .stages(dto.getStages().stream().map(stageService::getByExternalId).collect(Collectors.toList()))
                .build();
    }
}
