package ru.magarusik.service.dto;

public record QuestionDTO(

        String title,
        long testId,
        long questionTypeId) {
}
