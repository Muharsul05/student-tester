package ru.magarusik.studenttestingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magarusik.studenttestingservice.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByTestId(long testId);
}
