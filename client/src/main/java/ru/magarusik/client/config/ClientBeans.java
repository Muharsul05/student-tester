package ru.magarusik.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.magarusik.client.client.RestClientTesting;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientTesting testingRestClient(
            @Value("${testing.services.testing-service.uri}") String serviceBaseURL,
            @Value("${testing.services.testing-service.context-path}") String serviceContextPath
    ) {
        return new RestClientTesting(RestClient.builder()
                .baseUrl(serviceBaseURL.concat(serviceContextPath))
                .build());
    }
}
