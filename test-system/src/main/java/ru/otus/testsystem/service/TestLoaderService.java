package ru.otus.testsystem.service;

import ru.otus.testsystem.domain.Test;

public interface TestLoaderService {
    Test loadFromResourceCsvFile();
}
