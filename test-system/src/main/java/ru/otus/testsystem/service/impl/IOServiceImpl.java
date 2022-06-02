package ru.otus.testsystem.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.testsystem.service.IOService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final Scanner in = new Scanner(System.in);
    private final PrintStream out = System.out;

    @Override
    public String inputString() {
        return in.nextLine();
    }

    @Override
    public void outputString(String message) {
        out.println(message);
    }

    @Override
    public void outputString(String template, Object... args) {
        out.printf(template + "%n", args);
    }

}
