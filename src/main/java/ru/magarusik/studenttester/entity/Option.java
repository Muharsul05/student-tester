package ru.magarusik.studenttester.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "option_entity")
@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String answer;
    private boolean correct;

    @Column(name = "question_id")
    private long questionId;
}
