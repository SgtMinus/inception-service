package ru.itmo.inceptionservice.service.user.userservice;

import ru.itmo.inceptionservice.controller.user.dto.AuthResponseDTO;
import ru.itmo.inceptionservice.controller.user.dto.CreateUserDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignInDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignUpDTO;
import ru.itmo.inceptionservice.model.user.entity.User;

import java.util.List;

public interface UserService {
    AuthResponseDTO register(SignUpDTO dto) throws Exception;
    AuthResponseDTO authenticate(SignInDTO dto) throws Exception;
    User createNewUser(CreateUserDTO dto) throws Exception;
    List<User> getAllUsers(); //no pagination?
    User getUserByEmail(String email);
}
