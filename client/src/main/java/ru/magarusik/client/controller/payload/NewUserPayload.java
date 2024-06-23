package ru.magarusik.client.controller.payload;

public record NewUserPayload(

        String username,
        String password,
        String authority
) {
}
