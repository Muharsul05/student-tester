package ru.magarusik.studenttestingclient.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.entity.Test;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientTestingRestClient implements TestingRestClient {

    private final RestClient restClient;

    public static final ParameterizedTypeReference<List<Test>>
            TESTS_TYPE_REFERENCE = new ParameterizedTypeReference<>() {
    };

    @Override
    public List<Test> findAllTests() {
        return this.restClient
                .get()
                .uri("/all/")
                .retrieve().body(TESTS_TYPE_REFERENCE);
    }

    @Override
    public List<Test> findAllTests(String filter) {
        return List.of();
    }

    @Override
    public Test createTest(String title, String details) {
        return null;
    }

    @Override
    public Optional<Test> findTest(int testId) {
        return Optional.empty();
    }

    @Override
    public void updateTest(int testId, String title, String details) {

    }

    @Override
    public void deleteTest(int testId) {

    }
}
