package ru.itmo.inceptionservice.service.dreams.dream;

import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;

import java.util.List;
import java.util.UUID;

public interface DreamService {
    List<Dream> getAllDreams(); //pagination?
    Dream getByExternalId(UUID uuid);
    Dream createNew();
}
