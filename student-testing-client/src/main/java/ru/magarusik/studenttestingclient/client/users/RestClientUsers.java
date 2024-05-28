package ru.magarusik.studenttestingclient.client.users;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.entity.User;

import java.util.List;

@RequiredArgsConstructor
public class RestClientUsers implements UserRestClient {

    private final RestClient restClient;

    public static final ParameterizedTypeReference<List<User>>
            USER_LIST = new ParameterizedTypeReference<>() {};

    @Override
    public List<User> findAllUsers() {
        return restClient
                .get()
                .uri("/api/v1/testing-service/users")
                .retrieve()
                .body(USER_LIST);
    }
}
