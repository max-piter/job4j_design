package ru.job4j.kiss;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MaxMin {

    private <T> T comparison(List<T> value, BiPredicate<T, T> predicate) {
        T result;
        if (value.isEmpty())  {
            result = null;
        } else {
            result = value.get(0);
        }
        for (T element: value) {
            result = predicate.test(result, element) ? result : element;
        }
        return result;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
            return comparison(value, (elem1, elem2) -> comparator.compare(elem1, elem2) >= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
            return max(value, comparator.reversed());
    }
}
