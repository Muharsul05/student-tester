package ru.magarusik.studenttestingclient.dto;

public record UserDTO(
        String login,
        String password,
        String email,
        String role) {
}
