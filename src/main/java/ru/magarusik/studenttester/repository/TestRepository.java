package ru.magarusik.studenttester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.studenttester.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
