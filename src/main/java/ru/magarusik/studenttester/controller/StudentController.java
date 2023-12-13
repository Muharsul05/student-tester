package ru.magarusik.studenttester.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magarusik.studenttester.entity.UserEntity;
import ru.magarusik.studenttester.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<UserEntity> getAllStudents() {
        return studentService.getAllStudents();
    }
}
