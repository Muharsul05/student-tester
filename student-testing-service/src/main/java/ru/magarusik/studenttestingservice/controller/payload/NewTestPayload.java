package ru.magarusik.studenttestingservice.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTestPayload {

    private String title;
    private Timestamp createdDate;
}
