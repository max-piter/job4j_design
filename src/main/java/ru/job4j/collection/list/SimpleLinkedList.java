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

    /**
     * count size of the LinkedList.
     */
    private int size;

    /**
     * count operations, that changes the List.
     */
    private int modCount;

    /**
     * first Node.
     */
    private Node<E> firstNode;

    /**
     * Last Node.
     */
    private Node<E> lastNode;

    /**
     * public constructor,  to implement SimpleLinkedList.
     */
    public SimpleLinkedList() { }

    /**
     * method to add vlue to the List.
     * @param value the value - value
     */
    @Override
    public void add(final E value) {
        Node<E> current = lastNode;
        lastNode = new Node<>(value);
        if (current == null && size == 0) {
            firstNode = lastNode;
        } else {
            current.next = lastNode;
        }
        size++;
        modCount++;

    }

    /**
     * method to get value from  the List.
     * @param index the index - index of the Node
     * @return returns the value
     */
    @Override
    public E get(final int index) {
        Objects.checkIndex(index, size);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getElement();
    }

    /**
     * method to iterate throw the List.
     * @return values of the object
     */
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
     * вложенный класс.
     * в который оборачивается каждый объект связанного списка.
     * @param <E> объекты типа Е
     */
    private static class Node<E> {

        /**
         * value, that we store in the Node.
         */
        private E element;

        /**
         * Node for wrapping value.
         */
        private Node<E> next;


       Node(final E el) {
           this.element = el;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
