package ru.job4j.collection.list;

public interface List<E> extends Iterable<E> {
    /**
     * Add. - abstract method to add value.
     *
     * @param value the value - value
     */
    void add(E value);

    /**
     * Get e. - abstract method to get the value.
     * by index
     *
     * @param index the index - index
     * @return the e - value
     */
    E get(int index);
}


