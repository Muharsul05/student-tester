package ru.magarusik.studenttestingservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.magarusik.studenttestingservice.controller.payload.NewTestPayload;
import ru.magarusik.studenttestingservice.dto.TestDTO;
import ru.magarusik.studenttestingservice.entity.Test;
import ru.magarusik.studenttestingservice.service.TestService;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> createProduct(@Valid @RequestBody NewTestPayload payload,
                                           BindingResult bindingResult,
                                           UriComponentsBuilder uriComponentsBuilder)
            throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            Test test = this.testService.createTest(payload);
            return ResponseEntity
                    .created(uriComponentsBuilder
                            .replacePath("/api/v1/tests/{testTitle}")
                            .build(Map.of("testTitle", test.getTitle())))
                    .body(test);
        }
    }
}
