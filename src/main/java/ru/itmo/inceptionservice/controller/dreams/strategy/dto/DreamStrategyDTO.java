package ru.itmo.inceptionservice.controller.dreams.strategy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;

import java.util.UUID;

@AllArgsConstructor
@Data
public class DreamStrategyDTO {
    private UUID externalId;

    public static DreamStrategyDTO createFrom(DreamStrategy dreamStrategy){
        return new DreamStrategyDTO(dreamStrategy.getExternalId());
    }
}
