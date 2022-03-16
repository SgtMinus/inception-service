package ru.itmo.inceptionservice.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.inceptionservice.model.user.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String name;
    private String email;
    private String role;

    public static UserDTO createFrom(User us){
        return new UserDTO(
                us.getPersonData().getName(),
                us.getEmail(),
                us.getRole().toString()
        );
    }
}
