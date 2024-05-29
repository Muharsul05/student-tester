package ru.magarusik.studenttestingclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.magarusik.studenttestingclient.client.RestClientTesting;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final RestClientTesting userRestClient;

    @GetMapping
    public String findAllUsers(Model model) {
        model.addAttribute("users", this.userRestClient.findAllUsers());
        return "/users/list";
    }
}
