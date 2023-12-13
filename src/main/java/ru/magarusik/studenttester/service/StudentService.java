package ru.magarusik.studenttester.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttester.entity.UserEntity;
import ru.magarusik.studenttester.repository.UserEntityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final UserEntityRepository userEntityRepository;

    public List<UserEntity> getAllStudents() {
        return userEntityRepository.findAll()
                .stream()
                .filter(user -> "Студент".equals(user.getRole().getName()))
                .toList();
    }


}
