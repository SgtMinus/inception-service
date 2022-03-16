package ru.itmo.inceptionservice.controller.dreams.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.inceptionservice.model.dreams.order.entity.DreamOrder;

import java.util.UUID;

@AllArgsConstructor
@Data
public class DreamOrderDTO {

    private UUID externalId;

    public static DreamOrderDTO createFrom(DreamOrder dreamOrder){
        return new DreamOrderDTO(dreamOrder.getExternalId());
    }
}
