package ru.magarusik.client.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import ru.magarusik.client.controller.payload.NewTestPayload;
import ru.magarusik.client.dto.QuestionDTO;
import ru.magarusik.client.dto.TestDTO;
import ru.magarusik.client.dto.UserProfileDTO;

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
                .uri("/tests")
                .retrieve()
                .body(TESTS_LIST);
    }

    public void createTest(NewTestPayload payload) {
        this.restClient
                .post()
                .uri("/tests/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(payload)
                .retrieve()
                .body(NewTestPayload.class);
    }

    public TestDTO findTestByTitle(String title) {
        return this.restClient
                .get()
                .uri("/tests/{title}", title)
                .retrieve()
                .body(TestDTO.class);
    }

    public List<QuestionDTO> getQuestionsByTestId(long testId) {
        return this.restClient
                .get()
                .uri("/questions/{test_id}", testId)
                .retrieve()
                .body(QUESTIONS_LIST);
    }

    public UserProfileDTO getUserProfile(long userId) {
        return this.restClient
                .get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .body(UserProfileDTO.class);
    }
}
