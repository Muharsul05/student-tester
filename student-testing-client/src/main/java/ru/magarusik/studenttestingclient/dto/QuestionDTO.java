package ru.magarusik.studenttestingclient.dto;

public record QuestionDTO(
        String title,
        long testId,
        long questionTypeId) {
}
