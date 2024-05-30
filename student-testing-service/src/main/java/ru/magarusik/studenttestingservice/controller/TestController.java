package ru.magarusik.studenttestingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.magarusik.studenttestingservice.controller.payload.NewTestPayload;
import ru.magarusik.studenttestingservice.dto.TestDTO;
import ru.magarusik.studenttestingservice.service.TestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<TestDTO> getAllTests() {
        return testService.getAllTests();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody NewTestPayload payload) {
        System.out.println(payload);
        testService.createTest(payload);
    }

    @GetMapping("/{title}")
    public TestDTO findTestByTitle(@PathVariable("title") String title) {
        return testService.findTestByTitle(title);
    }
}
