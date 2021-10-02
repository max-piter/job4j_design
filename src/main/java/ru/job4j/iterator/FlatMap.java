package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * класс Flatmap -  реализация итератора для метода flatMap
 *
 * @param <T> объект типа Т
 */
public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    /**
     * Instantiates a new Flat map.
     *
     * @param data the data
     */
    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    /**
     * переопределённый метод hasNext()
     * проверяет, есть ли следующий элемент в текущем списке, если его нет  - меняет список
     * @return возвращает значение true если можно получить следующий элемент списка
     */
    @Override
    public boolean hasNext() {
        while (data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    /**
     * метод next() двигает курсор по элементам списка
     * @return возвращает текущий объект типа Т
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
