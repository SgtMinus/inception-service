package ru.itmo.inceptionservice.service.dreams.stage;

import ru.itmo.inceptionservice.controller.dreams.stage.dto.AddNewStageDTO;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;

import java.util.List;
import java.util.UUID;

public interface DreamStageService {
    List<DreamStage> getAllStages(UUID dreamId); // no pagination?
    DreamStage createStage(String email, AddNewStageDTO dto);
    DreamStage getByExternalId(UUID uuid);
}
