package ru.otus.quizsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quizsystem.domain.Quiz;
import ru.otus.quizsystem.service.QuizAppService;
import ru.otus.quizsystem.service.QuizLoaderService;
import ru.otus.quizsystem.service.QuizRunnerService;

@Service
@RequiredArgsConstructor
public class QuizAppServiceImpl implements QuizAppService {
    private final QuizLoaderService quizLoaderService;
    private final QuizRunnerService quizRunnerService;

    @Override
    public void run() {
        Quiz myQuiz = quizLoaderService.loadQuiz();
        quizRunnerService.run(myQuiz);
    }
}
