package ru.itmo.inceptionservice.controller.dreams.strategy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class AddNewStrategyDTO {
    private List<UUID> stages;
    private String dreamUUID;
}
