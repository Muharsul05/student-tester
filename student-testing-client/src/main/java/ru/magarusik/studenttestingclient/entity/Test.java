package ru.magarusik.studenttestingclient.entity;

import java.util.Date;

public record Test(
        String title,
        Date createdDate) {
}
