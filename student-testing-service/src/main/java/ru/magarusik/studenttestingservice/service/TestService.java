package ru.magarusik.studenttestingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttestingservice.dto.TestDTO;
import ru.magarusik.studenttestingservice.repository.TestRepository;
import ru.magarusik.studenttestingservice.utils.Converter;

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
}
