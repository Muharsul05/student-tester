package ru.magarusik.studenttestingclient.dto;

import java.util.Date;

public record TestDTO(
        long id,
        String title,
        Date createdDate) {
}
