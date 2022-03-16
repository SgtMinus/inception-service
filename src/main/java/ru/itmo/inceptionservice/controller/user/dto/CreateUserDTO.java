package ru.itmo.inceptionservice.controller.user.dto;

import lombok.Data;
import ru.itmo.inceptionservice.model.user.entity.UserRole;

@Data
public class CreateUserDTO {
    private String email;
    private String tempPassword;
    private UserRole role;
}
