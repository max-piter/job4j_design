package ru.job4j.kiss;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.*;



public class MaxMin {

    private <T> T comparison(List<T> value, BiPredicate<T, T> predicate) {
        T result;
        result = value.isEmpty() ? null : value.get(0);

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
