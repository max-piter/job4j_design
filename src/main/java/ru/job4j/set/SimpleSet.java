package ru.job4j.set;

import java.util.Iterator;
import java.util.Objects;

import ru.job4j.list.SimpleArrayList;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean ifAddSuccess = !contains(value);
            if (ifAddSuccess) {
                set.add(value);
            }
        return ifAddSuccess;
    }

    @Override
    public boolean contains(T value) {
        boolean ifContains = false;
            for (T element : set) {
                if (Objects.equals(value, element)) {
                    ifContains =  true;
                    break;
                }
            }
      return ifContains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
