package ru.magarusik.service.util;

import lombok.experimental.UtilityClass;
import ru.magarusik.service.dto.QuestionDTO;
import ru.magarusik.service.dto.TestDTO;
import ru.magarusik.service.dto.UserProfileDTO;
import ru.magarusik.service.entity.Question;
import ru.magarusik.service.entity.Test;
import ru.magarusik.service.entity.UserProfile;

@UtilityClass
public class Converter {

    public UserProfileDTO convert(UserProfile userProfile) {
        return new UserProfileDTO(
                userProfile.getId(),
                userProfile.getEmail(),
                userProfile.getFirstName(),
                userProfile.getLastName(),
                userProfile.getPatronymic(),
                userProfile.getDateOfBirth(),
                userProfile.getCourse(),
                userProfile.getGroupName()
        );
    }

    public UserProfile convert(UserProfileDTO userDTO) {
        return UserProfile.builder()
                .userId(userDTO.userId())
                .email(userDTO.email())
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .patronymic(userDTO.patronymic())
                .dateOfBirth(userDTO.dateOfBirth())
                .groupName(userDTO.groupName())
                .course(userDTO.course())
                .build();
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
