package ru.itmo.inceptionservice.service.dreams.strategy;

import ru.itmo.inceptionservice.controller.dreams.strategy.dto.AddNewStrategyDTO;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;

import java.util.List;
import java.util.UUID;

public interface DreamStrategyService {
    List<DreamStrategy> getAll(UUID dreamId);
    DreamStrategy addNew( AddNewStrategyDTO dto);
    DreamStrategy getByExternalId(UUID uuid);
}
