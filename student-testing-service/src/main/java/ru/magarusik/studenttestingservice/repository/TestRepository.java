package ru.magarusik.studenttestingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.studenttestingservice.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}