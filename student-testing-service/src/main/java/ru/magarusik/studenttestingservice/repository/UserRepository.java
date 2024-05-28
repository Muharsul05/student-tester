package ru.magarusik.studenttestingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.studenttestingservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
