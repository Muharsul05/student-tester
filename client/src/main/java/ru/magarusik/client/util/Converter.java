package ru.magarusik.client.util;

import lombok.experimental.UtilityClass;
import ru.magarusik.client.dto.QuestionDTO;
import ru.magarusik.client.dto.enums.QuestionTypes;
import ru.magarusik.client.model.QuestionModel;

@UtilityClass
public class Converter {

    public QuestionModel convert(QuestionDTO questionDTO) {
        return new QuestionModel(questionDTO.title(),
                QuestionTypes.getName((int) questionDTO.questionTypeId())
        );
    }
}
