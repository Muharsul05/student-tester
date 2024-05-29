package ru.magarusik.studenttestingclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.magarusik.studenttestingclient.client.RestClientTesting;
import ru.magarusik.studenttestingclient.controller.payload.NewTestPayload;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {

    private final RestClientTesting testingRestClient;

    @GetMapping
    public String getAllTestsListPage(Model model) {
        model.addAttribute("tests", testingRestClient.findAllTests());
        return "/tests/list";
    }

    @GetMapping("/create")
    public String createTestPage(Model model, NewTestPayload newTestPayload) {
        model.addAttribute("testPayload", newTestPayload);
        return "/tests/create";
    }


    @PostMapping("/create")
    public String createProduct(NewTestPayload payload) {
        payload.setCreatedDate(new Date());
        this.testingRestClient.createTest(payload);
        return "redirect:/tests/list/%s".formatted(payload.getTitle());
    }
}
