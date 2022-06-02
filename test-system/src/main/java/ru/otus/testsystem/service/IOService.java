package ru.otus.testsystem.service;

public interface IOService {
    String inputString();
    void outputString(String message);
    void outputString(String template, Object ...args);
}
