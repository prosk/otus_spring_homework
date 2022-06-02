package ru.otus.testsystem.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.testsystem.config.TestingProperties;
import ru.otus.testsystem.domain.Question;
import ru.otus.testsystem.domain.Test;
import ru.otus.testsystem.service.TestLoaderService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Service
public class TestLoaderServiceImpl implements TestLoaderService {
    private final TestingProperties testingProperties;

    public TestLoaderServiceImpl(TestingProperties testingProperties) {
        this.testingProperties = testingProperties;
    }

    @Override
    public Test loadFromResourceCsvFile() {
        InputStream is = getFileFromResourceAsStream(testingProperties.getFilename());
        Scanner sc = new Scanner(is);
        ArrayList<String> fileLines = new ArrayList<>();
        sc.useDelimiter("\n");
        sc.forEachRemaining(fileLines::add);

        ArrayList<Question> questions = new ArrayList<>();
        for (String line: fileLines) {
            String[] lineParts = line.split("\\;");
            Question currQuestion = new Question(Integer.parseInt(lineParts[0]),
                    lineParts[1], new ArrayList<>(Arrays.asList(lineParts[2].split("\\,"))));
            questions.add(currQuestion);
        }
        return new Test("My Test", questions);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
