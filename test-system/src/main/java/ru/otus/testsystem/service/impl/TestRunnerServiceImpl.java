package ru.otus.testsystem.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.testsystem.config.TestingProperties;
import ru.otus.testsystem.domain.Question;
import ru.otus.testsystem.domain.Test;
import ru.otus.testsystem.service.IOService;
import ru.otus.testsystem.service.TestRunnerService;

import java.util.ArrayList;

@Service
public class TestRunnerServiceImpl implements TestRunnerService {
    private final TestingProperties testingProperties;
    private final IOService ioService;

    public TestRunnerServiceImpl(TestingProperties testingProperties, IOService ioService) {
        this.testingProperties = testingProperties;
        this.ioService = ioService;
    }
    @Override
    public void run(Test test) {
        ioService.outputString("Welcome to our perfect Test System!!!");
        ArrayList<Question> questions = test.getQuestions();
        ioService.outputString("Input your name and surname: ");
        String userName = ioService.inputString();
        ioService.outputString(userName + ", your have to pass test '" + test.getName() +
                "' with " + questions.size() + " questions. Good luck!!! ");

        int rightAnswersCount = 0;
        for(Question currQuestion: questions) {
            ioService.outputString("Question: " + currQuestion.getText());

            ioService.outputString("Your answer: ");
            String currAnswer = ioService.inputString();

            if (currQuestion.isRightAnswer(currAnswer)) {
                rightAnswersCount++;
                ioService.outputString("RIGHT!");
            } else {
                ioService.outputString("WRONG!");
            }

        }
        int rightAnswersPercent = rightAnswersCount * 100 / questions.size();
        ioService.outputString("Percent of right answers: " + rightAnswersPercent);

        if (rightAnswersPercent >= testingProperties.getMinimalRightAnswersPercent()) {
            ioService.outputString("TEST PASSED");
        } else {
            ioService.outputString("TEST NOT PASSED");
        }

    }
}
