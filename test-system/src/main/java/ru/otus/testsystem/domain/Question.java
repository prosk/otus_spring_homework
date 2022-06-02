package ru.otus.testsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class Question {
    private final int orderNum;
    private final String text;
    private final ArrayList<String> rightAnswers;

    public boolean isRightAnswer(String answer) {
        return rightAnswers.contains(answer);
    }
}
