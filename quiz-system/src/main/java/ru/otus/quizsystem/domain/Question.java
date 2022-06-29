package ru.otus.quizsystem.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Question {
    private final int orderNum;
    private final String text;
    private final List<String> rightAnswers;

    public boolean isRightAnswer(String answer) {
        return rightAnswers.contains(answer);
    }
}
