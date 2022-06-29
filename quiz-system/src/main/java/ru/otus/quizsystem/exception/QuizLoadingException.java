package ru.otus.quizsystem.exception;

public class QuizLoadingException extends RuntimeException {
    public QuizLoadingException(String message) {
        super(message);
    }

    public QuizLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
