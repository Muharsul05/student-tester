package ru.magarusik.studenttester.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttester.entity.Question;
import ru.magarusik.studenttester.repository.QuestionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionByID(long id) {
        return questionRepository.getReferenceById(id);
    }

    public List<Question> getQuestionsByTestID(long id) {
        return questionRepository.getQuestionsByTestId(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(long id) {
        questionRepository.deleteById(id);
    }
}


