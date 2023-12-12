package ru.magarusik.studenttester.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magarusik.studenttester.entity.UserEntity;
import ru.magarusik.studenttester.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserEntityController {
    private final UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public void saveUser(UserEntity userEntity) {
        userService.saveUser(userEntity);
    }
}
