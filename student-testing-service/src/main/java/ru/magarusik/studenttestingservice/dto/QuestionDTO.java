package ru.magarusik.studenttestingservice.dto;

public record QuestionDTO(
        String title,
        long testId,
        long questionTypeId) {
}
