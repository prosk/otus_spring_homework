package ru.otus.testsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.testsystem.domain.Test;
import ru.otus.testsystem.service.TestLoaderService;
import ru.otus.testsystem.service.TestRunnerService;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        TestLoaderService testLoaderService = context.getBean(TestLoaderService.class);
        Test myTest = testLoaderService.loadFromResourceCsvFile();

        TestRunnerService testRunnerService = context.getBean(TestRunnerService.class);
        testRunnerService.run(myTest);
    }
}
