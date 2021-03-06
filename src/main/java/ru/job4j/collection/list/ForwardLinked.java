package ru.job4j.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс ForwardLinked реализует контейнер данных  на базе односвязного списка.
 * @param <T> the type parameter
 */
public class ForwardLinked<T> implements Iterable<T> {

    /**
     * ссылка на первый элемент контейнера.
     */
    private Node<T> head;

    /**
     * аddFirst  - метод добавляет элемент в начало списка.
     * @param value - элемент типа Т
     */
    public void addFirst(final T value) {
        head = new Node<>(value, head);
    }


    /**
     * Add. метод добавляет элемент в односвязный список.
     * @param value  - элемент который необходимо добавить
     */
    public void add(final T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }


    /**
     * метод  revert - метод  оборачивает  односвязный список.
     * путём замены ссылок.
     *
     * @return the boolean
     */
    public boolean revert() {
        boolean rsl = head != null && head.next != null;
        if (rsl) {
                Node<T> current = head.next;
                head.next = null;
                while (current != null) {
                    Node<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        return rsl;
    }


    /**
     * deleteFirst - метод  удаляет первый элемент.
     * с помощью  обнуления ссылки на следующий
     * @return возвращает значение удалённой Ноды
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> deletedValue = head;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            deletedValue.next = null;
        }
        return deletedValue.value;
    }

    /**
     * Итератор класса.
     * @return возвращает текущий элемент
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * Вложенный класс описывает модель данных узла Node.
     * @param <T> принимает объект коллекции
     */
    private static class Node<T> {

        /**
         * The Value - viriable to store the date.
         */
        private T value;

        /**
         * The next - viriable to store address to the next Node.
         */
        private Node<T> next;

        Node(final T val, final Node<T> nextNode) {
            this.value = val;
            this.next = nextNode;
        }
    }
}
