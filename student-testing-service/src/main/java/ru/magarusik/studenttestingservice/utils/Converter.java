package ru.magarusik.studenttestingservice.utils;

import ru.magarusik.studenttestingservice.dto.QuestionDTO;
import ru.magarusik.studenttestingservice.dto.TestDTO;
import ru.magarusik.studenttestingservice.dto.UserDTO;
import ru.magarusik.studenttestingservice.entity.Question;
import ru.magarusik.studenttestingservice.entity.Test;
import ru.magarusik.studenttestingservice.entity.User;

public class Converter {

    public static UserDTO convert(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getDateOfBirth(),
                user.getCourse(),
                user.getGroup()
        );
    }

    public static TestDTO convert(Test test) {
        return new TestDTO(
                test.getId(),
                test.getTitle(),
                test.getCreatedDate()
        );
    }

    public static QuestionDTO convert(Question question) {
        return new QuestionDTO(
                question.getTitle(),
                question.getTestId(),
                question.getQuestionTypeId()
        );
    }
}
