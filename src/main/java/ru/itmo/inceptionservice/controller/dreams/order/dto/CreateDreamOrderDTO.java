package ru.itmo.inceptionservice.controller.dreams.order.dto;

import lombok.Data;
import ru.itmo.inceptionservice.controller.user.dto.PersonDataDTO;

import java.time.LocalDate;

@Data
public class CreateDreamOrderDTO {
    private final PersonDataDTO targetUserInfo;
    private final LocalDate deadline;
}
