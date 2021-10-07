package ru.job4j.list;

/**
 * The interface List.
 * Базовый интерфейс для нашего SimpleArrayList
 * @param <T> the type parameter
 */
public interface List<T> extends Iterable<T> {
    void add(T value);
    T set(int index, T newValue);
    T remove(int index);
    T get(int index);
    int size();
}
