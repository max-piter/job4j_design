package ru.job4j.collection.list;

/**
 * The type SimpleStack - класс реализация структуры хранения Stack.
 * на базе односвязного списка.
 * Добавляем в начало, берём тоже сначала
 *
 * @param <T> the type parameter
 */
public class SimpleStack<T> {

    /**
     * linked - LinkeList on which  the SimpleStack based.
     */
    private ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * size of the Stack.
     */
    private int size = 0;

    /**
     * Pop - метод для удаления с начала списка.
     *
     * @return возвращаем удалённый элемент
     */
    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    /**
     * Push - метод для добавления в начало  списка.
     *
     * @param value the value
     */
    public void push(final T value) {
        linked.addFirst(value);
        size++;
    }

    /**
     * Size int - method for returning size of the Stack.
     *
     * @return the int - size of the Stack
     */
    public int size() {
        return size;
    }

    /**
     * Is empty boolean - checking if empty.
     *
     * @return the boolean - true/false
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
