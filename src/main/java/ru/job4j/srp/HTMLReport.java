package ru.job4j.srp;

import java.util.function.Predicate;

public class HTMLReport implements Report {

    public Store store;

    public HTMLReport(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<table>")
                .append(System.lineSeparator())
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>")
                    .append(employee.getName()).append("</td><td>")
                    .append(employee.getHired()).append("</td><td>")
                    .append(employee.getFired()).append("</td><td>")
                    .append(employee.getSalary()).append("</td></tr>")
                    .append(System.lineSeparator());
        }
        text.append("</table>");
        return text.toString();
    }
}
