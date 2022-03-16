package ru.itmo.inceptionservice.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDataDTO {
    private final String name;
    private final String surname;
    private final String city;
    private final Integer age;
}
