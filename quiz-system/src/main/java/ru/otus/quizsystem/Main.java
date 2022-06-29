package ru.otus.quizsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.quizsystem.service.QuizAppService;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        QuizAppService quizAppService = context.getBean(QuizAppService.class);
        quizAppService.run();
    }
}
