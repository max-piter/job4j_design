package ru.job4j.collection.list;

import java.util.NoSuchElementException;

/**
 * класс SimpleQueue - реализация очереди(FIFO) на базе двух  стеков (LIFO).
 * принцип FIFO реализуется следующим образом:
 * входящие элементы сохраняется в первом стеке
 * если надо извлечь элемент,
 * все элементы перекладываются во второй стэк в обратном порядке,
 * и из  второго извлекаются по правилам стэка.
 *Таким образом, достигается принцип FIFO -
 *  первый вошедший в очередь, первым же из  неё выходит,
 *
 * @param <T> the type parameter
 */
public class SimpleQueue<T> {

    /**
     * first Steck, where we put objects.
     */
    private final   SimpleStack<T> in = new SimpleStack<>();

    /**
     * Second Steck, to put objects from the first.
     */
    private final SimpleStack<T> out = new SimpleStack<>();


    /**
     * метод Poll - удаляет элемент из  очереди и возвращает его.
     *
     * @return удалённый элемент
     */
    public T poll() {
        if (in.isEmpty() && out.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     *метод Push - добавляет элемент.
     *
     * @param value  - элемент который необходимо добавить
     */
    public void push(final T value) {

        in.push(value);
    }
}
