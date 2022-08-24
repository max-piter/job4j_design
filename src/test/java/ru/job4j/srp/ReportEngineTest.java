package ru.job4j.srp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.*;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.Report.LINE_SEPERATOR;
import static ru.job4j.ood.srp.ReportEngine.DATE_FORMAT;


class ReportEngineTest {

    MemStore store = new MemStore();
    Calendar now = Calendar.getInstance();
    Employee worker = new Employee("Ivan", now, now, 100);

    @Test
    public void whenOldGenerated() {
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(LINE_SEPERATOR)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(LINE_SEPERATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHTMLGenerated() {
        store.add(worker);
        Report htmlReport = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<html lang=\"ru\">\n<head>\n  <meta charset=\"UTF-8\">\n"
                        + "  <title>HTML Report</title>\n</head>\n<body>\n")
                .append("<table>")
                .append(LINE_SEPERATOR)
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(LINE_SEPERATOR)
                .append("<tr><td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td></tr>")
                .append(LINE_SEPERATOR)
                .append("</table>").append(LINE_SEPERATOR)
                .append("</body>\n</ntml>");
        assertThat(htmlReport.generate(em -> true)).isEqualTo(expect.toString());
    }
    @Test
    public void whenSalaryInEuroGenerated() {
        store.add(worker);
        AccountingReport ar = new AccountingReport(65, store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(LINE_SEPERATOR)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * ar.getInEuro()).append(ar.EURO).append(";")
                .append(LINE_SEPERATOR);
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
                .append(LINE_SEPERATOR)
                .append(emp2.getName()).append(";")
                .append(emp2.getSalary()).append(";")
                .append(LINE_SEPERATOR)
                .append(emp1.getName()).append(";")
                .append(emp1.getSalary()).append(";")
                .append(LINE_SEPERATOR);
        assertThat(hrRrep.generate(em -> true)).isEqualTo(expect.toString());
    }
}