package ru.magarusik.studenttestingclient.client.users;

import ru.magarusik.studenttestingclient.entity.User;

import java.util.List;

public interface UserRestClient {

    List<User> findAllUsers();
}
