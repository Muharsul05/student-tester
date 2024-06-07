package ru.magarusik.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.service.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    Test findTestByTitle(String title);
}
