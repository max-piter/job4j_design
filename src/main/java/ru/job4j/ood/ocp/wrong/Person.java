package ru.job4j.ood.ocp.wrong;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 * The type Person. - не расширяемый код  сохранения данных.
 * при желании сохранить данные о работниках помимо File или Database, например в Облако,
 * придётся менять функционал класса EployeeSave
 * решение:
 * создание интерфейса
 * interface SaveInterface {
 *     boolean save(Path path, List<Employee> list);
 * }
 * + создание разных  классов для всех  видов сохранения с реализацией данного интерфейса
 */
public class Person {
    String name;
    String surname;
    int age;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class Employee extends Person {

    String skill;
    Date hired;
    Date fired;
    List<Employee> list;

    public Employee(String name, String surname, Date hired, Date fired, String skill) {
        super(name, surname);
        this.hired = hired;
        this.fired = fired;
        this.skill = skill;
    }

    public static boolean addToList(Employee emp) {
        return true;
    }
}

class EployeeSave {

    public static boolean saveToFile(List<Employee> list) {
        return true;
    }

    public static boolean saveToDB(List<Employee> list) {
        return true;
    }
}

interface SaveInterface {
    boolean save(Path path, List<Employee> list);
}
