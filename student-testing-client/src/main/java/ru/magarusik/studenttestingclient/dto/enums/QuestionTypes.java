package ru.magarusik.studenttestingclient.dto.enums;

public enum QuestionTypes {
    SINGLE_CHOICE("Один верный ответ"),
    MULTIPLE_CHOICE("Несколько верных ответов"),
    FILL_IN_THE_BLANK("Написать ответ"),
    TRUE_OR_FALSE("Верно или нет");

    private final String name;

    QuestionTypes(String name) {
        this.name = name;
    }

    public static String getName(int id) {
        return QuestionTypes.values()[id - 1].name;
    }
}
