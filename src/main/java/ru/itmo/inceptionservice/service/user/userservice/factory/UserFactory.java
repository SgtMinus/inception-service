package ru.itmo.inceptionservice.service.user.userservice.factory;

import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.controller.user.dto.CreateUserDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignUpDTO;
import ru.itmo.inceptionservice.model.user.entity.PersonData;
import ru.itmo.inceptionservice.model.user.entity.User;
import ru.itmo.inceptionservice.model.user.entity.UserRole;

@Component
public class UserFactory {

    public User createNewUser(SignUpDTO dto) {
        var personData = dto.getPersonDataDTO();
        return User.builder()
                .role(UserRole.USER)
                .email(dto.getEmail())
                .password(dto.getPassword())
                .personData(
                        PersonData.builder()
                                .city(personData.getCity())
                                .name(personData.getName())
                                .age(personData.getAge())
                                .surname(personData.getSurname())
                                .build()
                )
                .build();
    }

    public User createNewUser(CreateUserDTO dto){
        return User.builder()
                .role(dto.getRole())
                .password(dto.getTempPassword())
                .email(dto.getEmail())
                .build();
    }

}
