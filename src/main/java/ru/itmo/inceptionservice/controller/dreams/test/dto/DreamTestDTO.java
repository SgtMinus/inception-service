package ru.itmo.inceptionservice.controller.dreams.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.model.dreams.test.entity.DreamStrategyTest;

import java.util.UUID;

@AllArgsConstructor
@Data
public class DreamTestDTO {
    private UUID externalId;

    public static DreamTestDTO createFrom(DreamStrategyTest dreamStrategyTest){
        return new DreamTestDTO(dreamStrategyTest.getExternalId());
    }
}
