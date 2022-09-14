package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;


import java.util.function.Predicate;


/**
 * The type Jsongenerator.
 * Генерирует отчёты в формате JSON
 * используем интерыейс Report из srp package
 */
public class JSONgenerator implements Report {
    Store store;

    public JSONgenerator(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Gson lib = new GsonBuilder().create();
        for (Employee employee : store.findBy(filter)) {
            text.append(lib.toJson(employee)).append(LINE_SEPERATOR);
        }
        return text.toString();
    }
}

