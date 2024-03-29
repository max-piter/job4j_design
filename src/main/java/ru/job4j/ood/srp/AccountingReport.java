package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class AccountingReport implements Report {

    private Store store;
    private final double inEuro;
    public static final char EURO = 128;

    public AccountingReport(double euroCourse, Store store) {
        this.inEuro = 1 / euroCourse;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(LINE_SEPERATOR);
        for (Employee employee: store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * inEuro).append(EURO).append(";")
                    .append(LINE_SEPERATOR);
        }
        return text.toString();
    }

    public Double getInEuro() {
        return inEuro;
    }
}
