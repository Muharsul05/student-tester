package ru.magarusik.studenttestingservice.controller.payload;

import java.util.Date;

public record NewTestPayload(
    String title,
    Date date
) {
}
