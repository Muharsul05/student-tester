package ru.magarusik.studenttestingclient.entity;

public record User(
        String login,
        String password,
        String email,
        String role
) {
}
