package ru.itmo.inceptionservice.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.user.dto.CreateUserDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignInDTO;
import ru.itmo.inceptionservice.controller.user.dto.SignUpDTO;
import ru.itmo.inceptionservice.controller.user.dto.UserDTO;
import ru.itmo.inceptionservice.service.user.userservice.UserService;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        log.info("get all users");
        return ResponseEntity.ok(
                userService.getAllUsers()
                        .stream()
                        .map(UserDTO::createFrom)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping()
    public ResponseEntity<?> addNewUser(@RequestBody CreateUserDTO userDTO) { //admin create new user with specific role
        log.info("start create user {}", userDTO);
        return ResponseEntity.ok(UserDTO.createFrom(userService.createNewUser(userDTO)));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerNewUser(@RequestBody SignUpDTO signUpDTO) {
        log.info("start register user {}", signUpDTO);
        return ResponseEntity.ok(userService.register(signUpDTO));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authInSystem(@RequestBody SignInDTO signInDTO) {
        log.info("start authenticate user {}", signInDTO);
        return ResponseEntity.ok(userService.authenticate(signInDTO));
    }

}
