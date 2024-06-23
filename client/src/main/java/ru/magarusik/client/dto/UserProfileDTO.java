package ru.magarusik.client.dto;

import java.sql.Date;

public record UserProfileDTO(

        long userId,
        String email,
        String firstName,
        String lastName,
        String patronymic,
        Date dateOfBirth,
        int course,
        String groupName) {
}
