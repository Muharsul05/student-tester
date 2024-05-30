package ru.magarusik.studenttestingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@SpringBootApplication
public class StudentTestingClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTestingClientApplication.class, args);
    }
}
