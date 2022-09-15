package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

class JSONgeneratorTest {

    @Test
    public void whenGeneratedJSONReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Max", now, now, 600);
        store.add(worker);
        store.add(worker2);
        Report engine = new JSONgenerator(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"").append(worker.getName()).append("\",")
                .append("\"hired\":{")
                .append("\"year\":").append(worker.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(Calendar.SECOND)).append("},")
                .append("\"fired\":{")
                .append("\"year\":").append(worker.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(worker.getSalary()).append("},")
                .append("{\"name\":\"").append(worker2.getName()).append("\",")
                .append("\"hired\":{")
                .append("\"year\":").append(worker2.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker2.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker2.getHired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker2.getHired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker2.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker2.getHired().get(Calendar.SECOND)).append("},")
                .append("\"fired\":{")
                .append("\"year\":").append(worker2.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker2.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker2.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker2.getFired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker2.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker2.getFired().get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(worker2.getSalary()).append("}]");

        assertThat(engine.generate(emp -> true)).isEqualTo(expect.toString());
    }
}