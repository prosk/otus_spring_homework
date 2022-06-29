package ru.otus.quizsystem.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.quizsystem.config.QuizProperties;
import ru.otus.quizsystem.domain.Question;
import ru.otus.quizsystem.domain.Quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DisplayName("Quiz Csv Classpath loader service should ")
@ExtendWith(MockitoExtension.class)
public class QuizCsvClasspathLoaderTest {
    private static final String QUESTIONS_PARSING_FILE_NAME = "question_parsing_sample_data.csv";

    @Mock
    private QuizProperties quizProperties;
    @InjectMocks
    private QuizCsvClasspathLoader quizCsvClasspathLoader;

    @Test
    @DisplayName("create correct Question order number from line in csv file")
    void shouldCreateCorrectQuestionOrderNumFromFileLine() {
        given(quizProperties.getQuestionsCsvFilename()).willReturn(QUESTIONS_PARSING_FILE_NAME);
        Quiz myQuiz = quizCsvClasspathLoader.loadQuiz();
        Question firstQuestion = myQuiz.getQuestions().get(0);
        assertThat(firstQuestion.getOrderNum()).isEqualTo(1);
    }

    @Test
    @DisplayName("create correct Question text from line in csv file")
    void shouldCreateCorrectQuestionTextFromFileLine() {
        given(quizProperties.getQuestionsCsvFilename()).willReturn(QUESTIONS_PARSING_FILE_NAME);
        Quiz myQuiz = quizCsvClasspathLoader.loadQuiz();
        Question firstQuestion = myQuiz.getQuestions().get(0);
        assertThat(firstQuestion.getText()).isNotEmpty().isEqualTo("Question Text");
    }

}
