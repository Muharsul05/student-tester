package ru.magarusik.client.dto;

import java.util.Date;

public record TestDTO(

        long id,
        String title,
        Date createdDate) {
}
