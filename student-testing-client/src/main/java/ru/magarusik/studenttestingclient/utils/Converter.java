package ru.magarusik.studenttestingclient.utils;

import ru.magarusik.studenttestingclient.dto.QuestionDTO;
import ru.magarusik.studenttestingclient.dto.enums.QuestionTypes;
import ru.magarusik.studenttestingclient.model.QuestionModel;

public class Converter {
    public static QuestionModel convert(QuestionDTO questionDTO) {
        return new QuestionModel(questionDTO.title(),
                QuestionTypes.getName((int) questionDTO.questionTypeId())
        );
    }
}
