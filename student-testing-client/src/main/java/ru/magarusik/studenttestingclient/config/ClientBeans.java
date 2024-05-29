package ru.magarusik.studenttestingclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.client.testing.RestClientTesting;
import ru.magarusik.studenttestingclient.client.users.RestClientUsers;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientTesting testingRestClient(
            @Value("${testing.services.testing-service.uri}") String serviceBaseURL,
            @Value("${testing.services.testing-service.username}") String username,
            @Value("${testing.services.testing-service.password}") String password) {
        return new RestClientTesting(RestClient.builder()
                .baseUrl(serviceBaseURL)
                .requestInterceptor(
                        new BasicAuthenticationInterceptor(username, password))
                .build());
    }

    @Bean
    public RestClientUsers usersRestClient(
            @Value("${testing.services.testing-service.uri}") String serviceBaseURL,
            @Value("${testing.services.testing-service.username}") String username,
            @Value("${testing.services.testing-service.password}") String password) {
        return new RestClientUsers(RestClient.builder()
                .baseUrl(serviceBaseURL)
                .requestInterceptor(
                        new BasicAuthenticationInterceptor(username, password))
                .build());
    }
}
