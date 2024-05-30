package ru.magarusik.studenttestingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttestingservice.dto.QuestionDTO;
import ru.magarusik.studenttestingservice.repository.QuestionRepository;
import ru.magarusik.studenttestingservice.utils.Converter;

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
