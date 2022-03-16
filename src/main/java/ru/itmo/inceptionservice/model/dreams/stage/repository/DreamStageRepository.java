package ru.itmo.inceptionservice.model.dreams.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DreamStageRepository extends JpaRepository<DreamStage, Long> {
    Optional<DreamStage> findByExternalId(UUID externalId);
}
