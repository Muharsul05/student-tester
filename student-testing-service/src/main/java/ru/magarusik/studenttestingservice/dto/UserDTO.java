package ru.magarusik.studenttestingservice.dto;

public record UserDTO(
        String login,
        String password,
        String email,
        String role
) {
}
