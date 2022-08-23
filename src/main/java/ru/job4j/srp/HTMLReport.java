package ru.job4j.srp;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;
import java.util.function.Predicate;

public class HTMLReport implements Report {

    private Store store;

    public HTMLReport(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();

        String htmlHeader = "<html lang=\"ru\">\n<head>\n  <meta charset=\"UTF-8\">\n"
                + "  <title>HTML Report</title>\n</head>\n<body>\n<table>";
        String htmlBottom = "</table>\n</body>\n</ntml>";

        text.append(htmlHeader)
                .append(LINE_SEPERATOR)
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(LINE_SEPERATOR);

        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>")
                    .append(employee.getName()).append("</td><td>")
                    .append(employee.getHired()).append("</td><td>")
                    .append(employee.getFired()).append("</td><td>")
                    .append(employee.getSalary()).append("</td></tr>")
                    .append(LINE_SEPERATOR);
        }
        text.append(htmlBottom);
        return text.toString();
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        MemStore store = new MemStore();
        store.add(worker);
        Report htmlReport = new HTMLReport(store);
        System.out.println(htmlReport.generate(m -> true));
    }
}
