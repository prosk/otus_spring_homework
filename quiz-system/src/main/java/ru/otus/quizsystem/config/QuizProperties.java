package ru.otus.quizsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:quiz.properties")
public class QuizProperties {
    private String questionsCsvFilename;
    private int minimalRightAnswersPercent;

    public QuizProperties(@Value("${application.questionsCsvFileName}") String questionsCsvFilename,
                          @Value("${application.minimalRightAnswersPercent}") int minimalRightAnswersPercent) {
        this.questionsCsvFilename = questionsCsvFilename;
        this.minimalRightAnswersPercent = minimalRightAnswersPercent;
    }

    public String getQuestionsCsvFilename() {
        return questionsCsvFilename;
    }

    public int getMinimalRightAnswersPercent() {
        return minimalRightAnswersPercent;
    }
}
