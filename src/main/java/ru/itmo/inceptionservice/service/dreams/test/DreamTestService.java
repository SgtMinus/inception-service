package ru.itmo.inceptionservice.service.dreams.test;

import ru.itmo.inceptionservice.model.dreams.test.entity.DreamStrategyTest;

import java.util.List;
import java.util.UUID;

public interface DreamTestService {
    DreamStrategyTest getByExternalId(UUID uuid);
    List<DreamStrategyTest> getAllByDreamId(UUID dreamId);
    DreamStrategyTest addNewTest(UUID dreamId);
}
