package ru.magarusik.studenttestingservice.utils;

import ru.magarusik.studenttestingservice.dto.TestDTO;
import ru.magarusik.studenttestingservice.dto.UserDTO;
import ru.magarusik.studenttestingservice.dto.UserRoles;
import ru.magarusik.studenttestingservice.entity.Test;
import ru.magarusik.studenttestingservice.entity.User;

public class Converter {

    public static UserDTO convert(User user) {
        return new UserDTO(
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                getRoleById(user.getRoleId())
        );
    }

    public static TestDTO convert(Test test) {
        return new TestDTO(
                test.getTitle(),
                test.getCreatedDate()
        );
    }

    private static String getRoleById(long id) {
        return UserRoles.values()[(int) id - 1].name();
    }
}
