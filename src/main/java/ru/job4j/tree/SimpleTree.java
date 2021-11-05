package ru.job4j.tree;

import java.util.*;

/**
 * The type Simpletree - реализация класса Simpletree на базе бинарного дерева
 * @param <E> the type parameter
 */
public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * метод add(E parent, E child) - добавляет ребёнка по родителю
     * @param parent - родитель
     * @param child ребёнок
     * @return true/false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) {
                Node<E> newChild = new Node<>(child);
                findBy(parent).get().children.add(newChild);
                rsl = true;
             }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
