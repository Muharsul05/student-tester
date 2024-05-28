package ru.magarusik.studenttestingclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("message", "Hello user!");
        model.addAttribute("currentTime", dateFormat.format(new Date()));
        return "index";
    }
}
