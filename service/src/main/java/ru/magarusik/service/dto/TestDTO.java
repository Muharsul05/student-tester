package ru.magarusik.service.dto;

import java.sql.Timestamp;

public record TestDTO(

        long id,
        String title,
        Timestamp createdDate) {
}
