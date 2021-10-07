package ru.job4j.generics;


import java.util.Collection;
import java.util.HashMap;

public interface Store<T extends Base> {

        void add(T model);

        boolean replace(String id, T model);

        boolean delete(String id);

        T findById(String id);

        void print();
}
