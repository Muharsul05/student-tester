package ru.magarusik.studenttester.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "question_entity")
@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String content;

    @Column(name = "test_id")
    private long testId;
}
