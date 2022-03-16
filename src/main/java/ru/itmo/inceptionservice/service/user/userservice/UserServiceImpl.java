package ru.itmo.inceptionservice.service.user.userservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itmo.inceptionservice.controller.user.dto.AuthResponseDTO;
import ru.itmo.inceptionservice.controller.user.dto.CreateUserDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignInDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignUpDTO;
import ru.itmo.inceptionservice.model.user.entity.User;
import ru.itmo.inceptionservice.model.user.repository.UserRepository;
import ru.itmo.inceptionservice.service.token.TokenService;
import ru.itmo.inceptionservice.service.user.userservice.factory.UserFactory;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final UserFactory userFactory;

    @Override
    public AuthResponseDTO register(SignUpDTO dto) throws Exception {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new Exception("User already exist");
        }
        var newUser = userRepository.saveAndFlush(userFactory.createNewUser(dto));
        return constructResponse(newUser);
    }

    @Override
    public AuthResponseDTO authenticate(SignInDTO dto) throws Exception {
        var user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow();
        if(user.getPassword().equals(dto.getPassword())){
            return constructResponse(user);
        }
        throw new Exception();
    }

    @Override
    public User createNewUser(CreateUserDTO dto) throws Exception {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new Exception("User already exist");
        }
        return userRepository.saveAndFlush(userFactory.createNewUser(dto));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private AuthResponseDTO constructResponse(User user){
        return new AuthResponseDTO(user.getEmail(), tokenService.createToken(user));
    }
}
