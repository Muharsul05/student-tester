package ru.magarusik.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.magarusik.client.client.RestClientTesting;
import ru.magarusik.client.controller.payload.NewTestPayload;
import ru.magarusik.client.util.Converter;

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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String createTestPage(Model model, NewTestPayload newTestPayload) {
        model.addAttribute("testPayload", newTestPayload);
        return "/tests/create";
    }


    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String createTest(NewTestPayload payload) {
        payload.setCreatedDate(new Date());
        this.testingRestClient.createTest(payload);
        return "redirect:/tests";
    }

    @GetMapping("/{title}")
    public String getTestPage(Model model, @PathVariable("title") String title) {
        var test = testingRestClient.findTestByTitle(title);
        model.addAttribute("test", test);
        model.addAttribute("questions",
                testingRestClient.getQuestionsByTestId(test.id())
                        .stream()
                        .map(Converter::convert)
                        .toList());
        return "/tests/showTest";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String accessDenied() {
        return "errors";
    }
}
