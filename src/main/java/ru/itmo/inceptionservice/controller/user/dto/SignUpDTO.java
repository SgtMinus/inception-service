package ru.itmo.inceptionservice.controller.user.dto;

import lombok.Data;

@Data
public class SignUpDTO {
    private final String email;
    private final String password;
    private final PersonDataDTO personDataDTO;
}
