package ru.magarusik.studenttestingservice.dto;

import java.util.Date;

public record TestDTO(
        String title,
        Date createdDate) {
}
