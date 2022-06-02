package ru.otus.testsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:testing.properties")
public class TestingProperties {

    @Value("${filename}")
    private String filename;

    @Value("${criteria}")
    private int minimalRightAnswersPercent;

    public String getFilename() {
        return filename;
    }

    public int getMinimalRightAnswersPercent() {
        return minimalRightAnswersPercent;
    }
}
