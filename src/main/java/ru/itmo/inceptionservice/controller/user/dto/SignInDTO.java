package ru.itmo.inceptionservice.controller.user.dto;

import lombok.Data;

@Data
public class SignInDTO {
    private final String email;
    private final String password;
}
