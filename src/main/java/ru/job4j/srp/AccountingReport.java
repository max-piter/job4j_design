package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class AccountingReport implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public Store store;
    private final double inEuro;

    public AccountingReport(double euroCourse, Store store) {
        this.inEuro = 1 / euroCourse;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        char euro = 128;
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee: store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * inEuro).append(euro).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
