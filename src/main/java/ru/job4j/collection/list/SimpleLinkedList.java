package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * класс контейнер на базе связного списка.
 * @param <E> the type parameter
 */
public class SimpleLinkedList<E> implements List<E> {

    private int size;
    private int modCount;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public SimpleLinkedList() { }

    @Override
    public void add(E value) {
        Node<E> previous = lastNode;
        lastNode = new Node<>(previous, value, null);
        if (previous == null && size == 0) {
            firstNode = lastNode;
        } else {
            previous.next = lastNode;
        }
        size++;
        modCount++;

    }


    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> lastReturned = firstNode;
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }


            @Override
            public E next() {

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                Node<E> node = lastReturned;
                lastReturned = lastReturned.getNext();
                point++;
                return node.getElement();
            }

        };
    }


    /**
     * вложенный класс,  в который оборачивается каждый объект связанного списка
     * @param <E> объекты типа Е
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

    }
}
