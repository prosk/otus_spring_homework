package ru.otus.quizsystem.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.quizsystem.service.IOService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final Scanner in = new Scanner(System.in);
    private final PrintStream out = System.out;

    @Override
    public String readString() {
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
