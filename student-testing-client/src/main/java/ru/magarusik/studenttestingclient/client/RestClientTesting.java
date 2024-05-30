package ru.magarusik.studenttestingclient.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.controller.payload.NewTestPayload;
import ru.magarusik.studenttestingclient.dto.QuestionDTO;
import ru.magarusik.studenttestingclient.dto.TestDTO;

import java.util.List;

@RequiredArgsConstructor
public class RestClientTesting {

    private final RestClient restClient;

    public static final ParameterizedTypeReference<List<TestDTO>>
            TESTS_LIST = new ParameterizedTypeReference<>() {
    };

    public static final ParameterizedTypeReference<List<QuestionDTO>>
            QUESTIONS_LIST = new ParameterizedTypeReference<>() {
    };

    public List<TestDTO> findAllTests() {
        return this.restClient
                .get()
                .uri("/api/v1/testing-service/tests")
                .retrieve()
                .body(TESTS_LIST);
    }

    public void createTest(NewTestPayload payload) {
        System.out.println(payload);
        this.restClient
                .post()
                .uri("/api/v1/testing-service/tests/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(payload)
                .retrieve()
                .body(NewTestPayload.class);
    }

    public TestDTO findTestByTitle(String title) {
        return this.restClient
                .get()
                .uri("/api/v1/testing-service/tests/{title}", title)
                .retrieve()
                .body(TestDTO.class);
    }

    public List<QuestionDTO> getQuestionsByTestId(long testId) {
        return this.restClient
                .get()
                .uri("/api/v1/testing-service/questions/{test_id}", testId)
                .retrieve()
                .body(QUESTIONS_LIST);
    }
}
