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
    private Store store;
    private Gson lib;

    public JSONgenerator(Store store) {
        this.store = store;
        lib = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return lib.toJson(store.findBy(filter));
    }
}

