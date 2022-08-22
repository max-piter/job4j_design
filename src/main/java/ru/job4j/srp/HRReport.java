package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {
    private Store store;
    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> emps = store.findBy(filter);
        emps.sort((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()));

        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(LINE_SEPERATOR);
        for (Employee employee: emps) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(LINE_SEPERATOR);
        }
        return text.toString();
    }
}
