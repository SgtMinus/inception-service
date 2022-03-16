package ru.itmo.inceptionservice.model.dreams.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;

import java.util.Optional;
import java.util.UUID;

public interface DreamStageParticipantRepository extends JpaRepository<DreamStageParticipant, Long> {
    Optional<DreamStageParticipant> findByExternalId(UUID externalId);
}
