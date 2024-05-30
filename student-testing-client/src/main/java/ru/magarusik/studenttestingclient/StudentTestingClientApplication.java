package ru.magarusik.studenttestingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableMethodSecurity
@SpringBootApplication
public class StudentTestingClientApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "testing";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
        SpringApplication.run(StudentTestingClientApplication.class, args);
    }
}
