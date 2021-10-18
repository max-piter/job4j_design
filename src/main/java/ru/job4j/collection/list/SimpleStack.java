package ru.job4j.collection.list;

/**
 * The type SimpleЫtack - класс реализация структуры хранения Stack
 * на базе односвязного списка.
 * Добавляем в начало, берём тоже сначала
 *
 * @param <T> the type parameter
 */
public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size = 0;

    /**
     * Pop - метод для удаления с начала списка
     * @return возвращаем удалённый элемент
     */
    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    /**
     * Push - метод для добавления в начало  списка
     * @param value the value
     */
    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
