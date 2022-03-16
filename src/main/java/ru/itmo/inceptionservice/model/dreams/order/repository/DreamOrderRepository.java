package ru.itmo.inceptionservice.model.dreams.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.dreams.order.entity.DreamOrder;

import java.util.Optional;
import java.util.UUID;

public interface DreamOrderRepository extends JpaRepository<DreamOrder, Long> {
    Optional<DreamOrder> findByExternalId(UUID externalId);
}
