package ru.magarusik.client.dto;

public record QuestionDTO(
        String title,
        long testId,
        long questionTypeId) {
}
