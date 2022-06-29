package ru.otus.quizsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quizsystem.config.QuizProperties;
import ru.otus.quizsystem.domain.Question;
import ru.otus.quizsystem.domain.Quiz;
import ru.otus.quizsystem.exception.QuizLoadingException;
import ru.otus.quizsystem.service.QuizLoaderService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class QuizCsvClasspathLoader implements QuizLoaderService {
    private final QuizProperties quizProperties;

    @Override
    public Quiz loadQuiz() {
        List<String> fileLines = new ArrayList<>();
        String filename = quizProperties.getQuestionsCsvFilename();
        try (Scanner sc = new Scanner(getFileFromResourceAsStream(filename))) {
            sc.useDelimiter("\n");
            sc.forEachRemaining(fileLines::add);
        } catch (Exception e) {
            throw new QuizLoadingException("Cannot find in classpath or load csv file with name " + filename, e);
        }

        List<Question> questions = new ArrayList<>();
        for (String line: fileLines) {
            String[] lineParts = line.split("\\;");
            Question currQuestion = new Question(Integer.parseInt(lineParts[0]),
                    lineParts[1], new ArrayList<>(Arrays.asList(lineParts[2].split("\\,"))));
            questions.add(currQuestion);
        }
        return new Quiz("My Quiz", questions);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
