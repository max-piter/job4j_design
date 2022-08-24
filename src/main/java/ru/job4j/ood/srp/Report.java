package ru.job4j.ood.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public interface Report {
     SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
     String LINE_SEPERATOR = System.lineSeparator();

    String generate(Predicate<Employee> filter);
}
