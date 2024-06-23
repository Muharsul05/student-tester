package ru.magarusik.service.dto;

import java.sql.Date;

public record UserDTO(

        String username,
        String email,
        String firstName,
        String lastName,
        String patronymic,
        Date dateOfBirth,
        int course,
        String group) {
}
