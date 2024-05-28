package ru.magarusik.studenttestingservice.utils;

import ru.magarusik.studenttestingservice.dto.UserDTO;
import ru.magarusik.studenttestingservice.dto.UserRoles;
import ru.magarusik.studenttestingservice.entity.User;

public class Converter {
    public static UserDTO userToUserDTO(User user) {
        return new UserDTO(
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                getRoleById(user.getRoleId())
        );
    }

    private static String getRoleById(long id) {
        return UserRoles.values()[(int) id - 1].name();
    }
}
