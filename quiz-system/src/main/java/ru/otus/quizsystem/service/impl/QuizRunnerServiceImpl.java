package ru.otus.quizsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quizsystem.config.QuizProperties;
import ru.otus.quizsystem.domain.Question;
import ru.otus.quizsystem.domain.Quiz;
import ru.otus.quizsystem.service.IOService;
import ru.otus.quizsystem.service.QuizRunnerService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizRunnerServiceImpl implements QuizRunnerService {
    private final QuizProperties quizProperties;
    private final IOService ioService;

    @Override
    public void run(Quiz quiz) {
        List<Question> questions = quiz.getQuestions();

        ioService.outputString("Welcome to our perfect Quiz System!!!");
        ioService.outputString("Input your name and surname: ");
        String userName = ioService.readString();
        ioService.outputString("%s, your have to pass quiz '%s' with %d questions. Good luck!",
                userName, quiz.getName(), questions.size());

        int rightAnswersCount = 0;
        String currAnswer;
        for(Question currQuestion: questions) {
            ioService.outputString("Question %d. %s", currQuestion.getOrderNum(), currQuestion.getText());
            ioService.outputString("Your answer: ");
            currAnswer = ioService.readString();

            if (currQuestion.isRightAnswer(currAnswer)) {
                rightAnswersCount++;
                ioService.outputString("RIGHT!");
            } else {
                ioService.outputString("WRONG!");
            }

        }
        int rightAnswersPercent = rightAnswersCount * 100 / questions.size();
        ioService.outputString("Percent of right answers: %d", rightAnswersPercent);

        if (rightAnswersPercent >= quizProperties.getMinimalRightAnswersPercent()) {
            ioService.outputString("QUIZ PASSED");
        } else {
            ioService.outputString("QUIZ NOT PASSED");
        }

    }
}
