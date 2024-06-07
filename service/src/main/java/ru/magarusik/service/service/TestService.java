package ru.magarusik.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.service.controller.payload.NewTestPayload;
import ru.magarusik.service.dto.TestDTO;
import ru.magarusik.service.entity.Test;
import ru.magarusik.service.repository.TestRepository;
import ru.magarusik.service.util.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<TestDTO> getAllTests() {
        return testRepository.findAll().stream()
                .map(Converter::convert)
                .toList();
    }

    public void createTest(NewTestPayload payload) {
        Test test = new Test();
        test.setTitle(payload.getTitle());
        test.setCreatedDate(payload.getCreatedDate());
        testRepository.save(test);
    }

    public TestDTO findTestByTitle(String title) {
        return Converter.convert(testRepository.findTestByTitle(title));
    }
}
