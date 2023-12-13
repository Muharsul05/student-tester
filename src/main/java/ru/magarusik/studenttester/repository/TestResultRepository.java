package ru.magarusik.studenttester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.studenttester.entity.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}


