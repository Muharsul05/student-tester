package ru.magarusik.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.magarusik.client.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
