package ru.magarusik.studenttestingclient.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTestPayload {

    private String title;
    private Date createdDate;
}
