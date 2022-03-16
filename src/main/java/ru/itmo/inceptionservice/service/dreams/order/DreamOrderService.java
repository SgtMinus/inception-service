package ru.itmo.inceptionservice.service.dreams.order;

import ru.itmo.inceptionservice.controller.dreams.order.dto.CreateDreamOrderDTO;
import ru.itmo.inceptionservice.model.dreams.order.entity.DreamOrder;

import java.util.List;
import java.util.UUID;

public interface DreamOrderService {
    List<DreamOrder> getAllOrders(); //no pagination?
    DreamOrder createNewOrder(String customerEmail, CreateDreamOrderDTO dto);
    DreamOrder getByExternalId(UUID uuid);
    DreamOrder accept(String architectEmail, UUID externalId);
}
