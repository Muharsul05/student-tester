package ru.magarusik.studenttestingclient.client;

import ru.magarusik.studenttestingclient.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestingRestClient {
    List<Test> findAllTests();

    List<Test> findAllTests(String filter);

    Test createTest(String title, String details);

    Optional<Test> findTest(int testId);

    void updateTest(int testId, String title, String details);

    void deleteTest(int testId);
}
