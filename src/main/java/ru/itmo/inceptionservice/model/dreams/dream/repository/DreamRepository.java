package ru.itmo.inceptionservice.model.dreams.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;

public interface DreamRepository extends JpaRepository<Dream, Long> {
}
