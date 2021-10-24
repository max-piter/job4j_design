package ru.job4j.set;

import java.util.Iterator;
import ru.job4j.list.SimpleArrayList;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(10);
    private int nullPoint = 0;

    @Override
    public boolean add(T value) {
        boolean ifAddSuccess = false;
        if (value != null) {
            if (!contains(value)) {
                set.add(value);
                ifAddSuccess = true;
            }
        } else if (nullPoint < 1) {
            set.add(value);
            nullPoint++;
            ifAddSuccess = true;
        }
        return ifAddSuccess;
    }

    @Override
    public boolean contains(T value) {
        boolean ifContains = false;
            for (T element : set) {
                if (element != null) {
                    if (value.equals(element)) {
                        ifContains = true;
                    }
                } else {
                    ifContains =  true;
                }
            }
      return ifContains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
