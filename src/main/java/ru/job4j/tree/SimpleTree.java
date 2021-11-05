package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

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
        Optional<Node<E>> prnt = findBy(parent);
        if (prnt.isPresent() && findBy(child).isEmpty()) {
                prnt.get().children.add(new Node<>(child));
                rsl = true;
             }
        return rsl;
    }


    @Override
    public Optional<Node<E>> findBy(E value) {
       return findByPredicate(Node -> Node.value.equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }


    /**
     * метод  проверяет бинарность дерева
     * @return true/false
     */
    @Override
    public boolean isBinary() {
        return findByPredicate(Node -> Node.children.size() <= 2).isPresent();
    }
}
