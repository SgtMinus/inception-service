package ru.itmo.inceptionservice.model.dreams.strategy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DreamStrategyRepository extends JpaRepository<DreamStrategy, Long> {
    Optional<List<DreamStrategy>> findAllByDream_ExternalId(UUID dreamId);
    Optional<DreamStrategy> findByExternalId(UUID externalId);
}
