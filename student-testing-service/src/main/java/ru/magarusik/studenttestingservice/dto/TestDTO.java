package ru.magarusik.studenttestingservice.dto;

import java.sql.Timestamp;

public record TestDTO(
        long id,
        String title,
        Timestamp createdDate) {
}
