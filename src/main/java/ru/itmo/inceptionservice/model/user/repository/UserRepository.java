package ru.itmo.inceptionservice.model.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.inceptionservice.model.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
