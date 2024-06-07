package ru.magarusik.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.service.dto.QuestionDTO;
import ru.magarusik.service.repository.QuestionRepository;
import ru.magarusik.service.util.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionDTO> findQuestionByTestId(long testId) {
        return questionRepository.findAllByTestId(testId).stream()
                .map(Converter::convert)
                .toList();
    }
}
