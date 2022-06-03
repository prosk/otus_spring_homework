package ru.otus.testsystem.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.testsystem.config.TestingProperties;
import ru.otus.testsystem.domain.Question;
import ru.otus.testsystem.service.TestLoaderService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DisplayName("Test loader service should ")
public class TestLoaderServiceImplTest {
    private static final String TEST_FILE_NAME = "test_file_1.csv";

    private TestingProperties testingProperties;
    private TestLoaderService testLoaderService;

    @BeforeEach
    void setUp() {
        testingProperties = Mockito.mock(TestingProperties.class);
        given(testingProperties.getFilename()).willReturn(TEST_FILE_NAME);
        testLoaderService = new TestLoaderServiceImpl(testingProperties);
    }

    @Test
    @DisplayName("create correct Question order number from line in file")
    void shouldCreateCorrectQuestionOrderNumFromFileLine() {
        ru.otus.testsystem.domain.Test myTest = testLoaderService.loadFromResourceCsvFile();
        Question firstQuestion = myTest.getQuestions().get(0);
        assertThat(firstQuestion.getOrderNum()).isEqualTo(1);
    }

    @Test
    @DisplayName("create correct Question text from line in file")
    void shouldCreateCorrectQuestionTextFromFileLine() {
        ru.otus.testsystem.domain.Test myTest = testLoaderService.loadFromResourceCsvFile();
        Question firstQuestion = myTest.getQuestions().get(0);
        assertThat(firstQuestion.getText()).isNotEmpty().isEqualTo("Question Text");
    }

}
