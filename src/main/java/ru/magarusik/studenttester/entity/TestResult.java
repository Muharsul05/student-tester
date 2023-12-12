package ru.magarusik.studenttester.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "test_result")
@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column(name = "user_id")
    private long studentId;
    @Column(name = "test_id")
    private long testId;
    private int score;
}
