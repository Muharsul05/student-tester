package ru.magarusik.studenttester.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magarusik.studenttester.service.UserService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping(path = "/login")
    public UserDetails getAuthUser(Authentication authentication) {
        return userService.loadUserByUsername(authentication.getName());
    }
}
