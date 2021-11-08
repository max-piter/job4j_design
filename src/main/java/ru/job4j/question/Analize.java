package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


/**
 * The type Analize. класс содержит единственный метод, для анализа списков User
 */
public class Analize {

    /**
     * метод производит аналитику изменений в списках
     * спользуем структуру HashMap
     * внутри используем метод putIfAbsent(), помимо добавления отсутствующего элемента,
     * он возвращает все value, через  которые проходит - этим и воспользуемся
     *
     * @param previous - первоначальный список
     * @param current  -  конечный список
     * @return - возвращает объект класса Info с полученными данными
     */
    public static Info diff(Set<User> previous, Set<User> current) {
        int countChanged = 0;
        int countAdded = 0;

        Map<Integer, String> usersPrevious = new HashMap<>();

        for (User us : previous) {
            usersPrevious.put(us.getId(), us.getName());
        }

        for (User us : current) {
            String previousUserName = usersPrevious.putIfAbsent(us.getId(), us.getName());
             if (previousUserName != null) {
            if (!Objects.equals(us.getName(), previousUserName)) {
                countChanged++;
            }
        } else {
                    countAdded++;
                }
            }

        int countDeleted = previous.size() - current.size() + countAdded;
        return new Info(countAdded, countChanged, countDeleted);
    }
}




