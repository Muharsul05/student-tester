package ru.magarusik.studenttestingclient.utils;

import lombok.experimental.UtilityClass;
import ru.magarusik.studenttestingclient.dto.QuestionDTO;
import ru.magarusik.studenttestingclient.dto.enums.QuestionTypes;
import ru.magarusik.studenttestingclient.model.QuestionModel;

@UtilityClass
public class Converter {

    public QuestionModel convert(QuestionDTO questionDTO) {
        return new QuestionModel(questionDTO.title(),
                QuestionTypes.getName((int) questionDTO.questionTypeId())
        );
    }
}
