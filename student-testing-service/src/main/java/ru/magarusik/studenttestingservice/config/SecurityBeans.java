package ru.magarusik.studenttestingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityBeans {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/api/v1/testing-service/**")
                                .hasRole("ADMIN"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
