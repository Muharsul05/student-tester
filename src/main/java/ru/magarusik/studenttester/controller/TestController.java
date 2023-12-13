package ru.magarusik.studenttester.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magarusik.studenttester.entity.Test;
import ru.magarusik.studenttester.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/tests")
@AllArgsConstructor
public class TestController {
    public final TestService testService;

    @GetMapping
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }
}
