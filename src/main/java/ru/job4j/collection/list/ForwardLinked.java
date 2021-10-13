package ru.job4j.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс ForwardLinked реализует контейнер данных  на базе односвязного списка
 * @param <T> the type parameter
 */
public class ForwardLinked<T> implements Iterable<T> {
    /**
     * ссылка на первый элемент контейнера
     */
    private Node<T> head;


    /**
     * Add. метод добавляет элемент в односвязный список
     * @param value  - элемент который необходимо добавить
     */
    public void add(T value) {
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
     * deleteFirst - метод  удаляет первый элемент
     * создаём Ноду и присваиваем ей значение Ноды head, чтобы потом  вернуть её значение.
     * head  -  присваиваем значение ссылки head.next, если она есть.
     * таким образом Нода, которая находилась по ссылке head.next, становится первым элементом.
     *
     * @return возвращает значение удалённой Ноды
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> newNode = head;
        head = head.next;
        return newNode.value;
    }



    /**
     * Итератор класса
     * @return возвращает текущий элемент
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

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
     * Вложенный класс описывает модель данных узла Node
     * @param <T> принимает объект коллекции
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
