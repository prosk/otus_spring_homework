package ru.otus.testsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class Test {
    private final String name;
    private final ArrayList<Question> questions;
}
