package ru.magarusik.studenttester.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttester.entity.Test;
import ru.magarusik.studenttester.repository.TestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public Test getTestByID(long id) {
        return testRepository.getReferenceById(id);
    }

    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    public Test updateTest(Test test) {
        return testRepository.save(test);
    }

    public void deleteTest(long id) {
        testRepository.deleteById(id);
    }
}
