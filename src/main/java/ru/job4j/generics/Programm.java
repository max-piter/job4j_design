package ru.job4j.generics;

import java.util.List;

/**
 * учебный класс для тестирования работы контейнеров
 * состоит из  main  метода
 * The type Programm.
 */
public class Programm {
    public static void main(String[] args) {
        Store<User> us = new UserStore();
        User user1 = new User("1", "Max");
        User user2 = new User("2", "Nick");
        User user3 = new User("3", "Jane");
        User user4 = new User("4", "Maximus");
        User user5 = new User("5", "Nidgel");
        User user6 = new User("6", "John");

        us.add(user1);
        us.add(user2);
        us.add(user3);
        us.add(user4);
        us.add(user5);
        us.add(user6);

        us.print();

    }
}
