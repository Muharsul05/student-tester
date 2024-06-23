package ru.magarusik.client.controller.payload;

import java.util.Date;

public record NewTestPayload(

        String title,
        Date createdDate) {
}
