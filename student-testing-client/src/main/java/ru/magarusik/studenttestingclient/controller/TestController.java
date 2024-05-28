package ru.magarusik.studenttestingclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.magarusik.studenttestingclient.client.testing.RestClientTesting;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {

    private final RestClientTesting testingRestClient;

    @GetMapping
    public String getAllTests(Model model) {
        model.addAttribute("tests", testingRestClient.findAllTests());
        return "/tests/list";
    }
}
