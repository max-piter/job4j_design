package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The type Analize. класс содержит единственный метод, для анализа списков User
 */
public class Analize {

    /**
     * метод производит аналитику изменений в списках
     * спользуем структуру TreeMap, чтобы  поиск по значению занимал O(logN) времени
     * @param previous - первоначальный список
     * @param current -  конечный список
     * @return - возвращает объект класса Info с полученными данными
     */
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);

        Map<Integer, String> usersPrevious = new TreeMap<>();
        Map<Integer, String> usersCurrent = new TreeMap<>();

        for (User us: previous) {
            usersPrevious.put(us.getId(), us.getName());
        }

        for (User us: current) {
            usersCurrent.put(us.getId(), us.getName());
        }

        info.setChanged((int) usersPrevious.entrySet().stream()
                .filter(us -> usersCurrent.containsKey(us.getKey()))
                .filter(us -> !us.getValue().equals(usersCurrent.get(us.getKey())))
                .count());

        info.setAdded((int) usersCurrent.entrySet().stream()
                .filter(us -> !usersPrevious.containsKey(us.getKey()))
                .count());

        info.setDeleted((int) usersPrevious.entrySet().stream()
                .filter(us -> !usersCurrent.containsKey(us.getKey()))
                .count());

        return info;
    }

}
