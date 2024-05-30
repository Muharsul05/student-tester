package ru.magarusik.studenttestingservice.dto;

import java.sql.Timestamp;

public record TestDTO(
        String title,
        Timestamp createdDate) {
}
