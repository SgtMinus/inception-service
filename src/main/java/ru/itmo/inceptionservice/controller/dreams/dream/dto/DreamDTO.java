package ru.itmo.inceptionservice.controller.dreams.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.DreamStageDTO;
import ru.itmo.inceptionservice.controller.dreams.strategy.dto.DreamStrategyDTO;
import ru.itmo.inceptionservice.controller.user.dto.UserDTO;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class DreamDTO {
    private UUID externalId;
    private UserDTO architectInfo;
    private List<DreamStrategyDTO> strategies;
    private float resultDTO;

    public static DreamDTO createFrom(Dream dream){
        return new DreamDTO(
                dream.getExternalId(),
                UserDTO.createFrom(dream.getMainArchitect()),
                dream.getStrategies().stream().map(DreamStrategyDTO::createFrom).collect(Collectors.toList()),
                dream.getResultSuccessProbability()
        );
    }
}
