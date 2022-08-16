package ru.job4j.srp;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.srp.ReportEngine.DATE_FORMAT;


class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report htmlReport = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<table>")
                .append(System.lineSeparator())
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td></tr>")
                .append(System.lineSeparator())
                .append("</table>");
        assertThat(htmlReport.generate(em -> true)).isEqualTo(expect.toString());
    }
    @Test
    public void whenSalaryInEuroGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 65000);
        store.add(worker);
        Report ar = new AccountingReport(65, store);
        double euroCourse = 65;
        char euro = 128;
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() / euroCourse).append(euro).append(";")
                .append(System.lineSeparator());
        assertThat(ar.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenSalaryDescendingFilterGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee emp1 = new Employee("Ivan", now, now, 100);
        Employee emp2 = new Employee("Max", now, now, 600);
        store.add(emp1);
        store.add(emp2);
        Report hrRrep = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(emp2.getName()).append(";")
                .append(emp2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(emp1.getName()).append(";")
                .append(emp1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hrRrep.generate(em -> true)).isEqualTo(expect.toString());
    }
}