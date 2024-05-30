package ru.magarusik.studenttestingclient.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserPayload {

    private String username;
    private String password;
    private String authority;
}
