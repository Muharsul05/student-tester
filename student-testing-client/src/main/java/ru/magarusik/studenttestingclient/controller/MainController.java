package ru.magarusik.studenttestingclient.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");

    @GetMapping
    public String hello(Model model, Authentication authentication) {
        model.addAttribute("message", "Hello %s!".formatted(authentication.getName()));
        model.addAttribute("currentTime", dateFormat.format(new Date()));
        return "index";
    }
}
