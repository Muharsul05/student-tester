package ru.magarusik.studenttestingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magarusik.studenttestingservice.dto.QuestionDTO;
import ru.magarusik.studenttestingservice.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{test_id}")
    public List<QuestionDTO> getQuestionsByTest(@PathVariable("test_id") long testId) {
        return questionService.findQuestionByTestId(testId);
    }
}
