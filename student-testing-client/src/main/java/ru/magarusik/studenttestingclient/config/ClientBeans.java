package ru.magarusik.studenttestingclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.client.testing.RestClientTesting;
import ru.magarusik.studenttestingclient.client.users.RestClientUsers;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientTesting testingRestClient(
            @Value("${testing.services.testing-service.uri}") String serviceBaseURL) {
        return new RestClientTesting(RestClient.builder()
                .baseUrl(serviceBaseURL)
                .build());
    }

    @Bean
    public RestClientUsers usersRestClient(
            @Value("${testing.services.testing-service.uri}") String serviceBaseURL) {
        return new RestClientUsers(RestClient.builder()
                .baseUrl(serviceBaseURL)
                .build());
    }
}
