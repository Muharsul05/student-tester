package ru.magarusik.studenttestingclient.confing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.magarusik.studenttestingclient.client.RestClientTestingRestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientTestingRestClient testingRestClient(
            @Value("${ru.magarusik.service.uri:https://localhost:9090}") String catalogueServiceBaseUri) {
        return new RestClientTestingRestClient(RestClient.builder()
                .baseUrl(catalogueServiceBaseUri)
                .build());
    }
}
