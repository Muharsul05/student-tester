package ru.magarusik.studenttestingclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.magarusik.studenttestingclient.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
