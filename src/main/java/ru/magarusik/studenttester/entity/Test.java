package ru.magarusik.studenttester.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "test_entity")
@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String title;
}
