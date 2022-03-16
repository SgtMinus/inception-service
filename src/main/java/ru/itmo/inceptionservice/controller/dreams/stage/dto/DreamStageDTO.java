package ru.itmo.inceptionservice.controller.dreams.stage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;

import java.util.UUID;

@AllArgsConstructor
@Data
public class DreamStageDTO {
    private UUID externalId;

    public static DreamStageDTO createFrom(DreamStage dreamStage){
        return new DreamStageDTO(dreamStage.getExternalId());
    }
}
