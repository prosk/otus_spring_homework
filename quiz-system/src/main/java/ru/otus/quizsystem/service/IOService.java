package ru.otus.quizsystem.service;

public interface IOService {
    String readString();
    void outputString(String message);
    void outputString(String template, Object ...args);
}
