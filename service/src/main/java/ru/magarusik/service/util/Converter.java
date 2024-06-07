package ru.magarusik.service.util;

import lombok.experimental.UtilityClass;
import ru.magarusik.service.dto.QuestionDTO;
import ru.magarusik.service.dto.TestDTO;
import ru.magarusik.service.dto.UserDTO;
import ru.magarusik.service.entity.Question;
import ru.magarusik.service.entity.Test;
import ru.magarusik.service.entity.User;

@UtilityClass
public class Converter {

    public UserDTO convert(User user) {
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

    public TestDTO convert(Test test) {
        return new TestDTO(
                test.getId(),
                test.getTitle(),
                test.getCreatedDate()
        );
    }

    public QuestionDTO convert(Question question) {
        return new QuestionDTO(
                question.getTitle(),
                question.getTestId(),
                question.getQuestionTypeId()
        );
    }
}
