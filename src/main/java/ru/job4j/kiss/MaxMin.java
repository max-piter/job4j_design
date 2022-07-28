package ru.job4j.kiss;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class MaxMin {

    private <T> T comparison(List<T> value, BiPredicate<T, T> predicate) {
        T result = value.get(0);
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


    public static void main(String[] args) {
     List<Integer> list = new ArrayList<>();
     for (int i = 0; i <= 20; i++) {
         list.add(i);
     }
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        list.add(234);

        int maxInt;
        int minInt;
        MaxMin max = new MaxMin();
        maxInt = max.max(list, Integer::compareTo);
        System.out.println(maxInt);
        minInt = max.min(list, Integer::compareTo);
        System.out.println(minInt);

        System.out.print(list);
        Supplier<Set<Integer>> sup = () -> new HashSet<Integer>(list);
        Set<Integer> integers = sup.get();
        System.out.println();
        for (Integer i: integers) {
            System.out.print(i);
        }

    }
}
