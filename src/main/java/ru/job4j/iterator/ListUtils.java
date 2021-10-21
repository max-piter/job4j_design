package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

/**
 * класс ListUtils -  является хранилищем методов ListIterator
 */
public class ListUtils {

    /**
     * addBefore метод  добавляет объект перед указанным индексом
     *
     * @param <T>   the type parameter
     * @param list  коллекция
     * @param index индекс, перед  которым нужно разместить объект
     * @param value объект, который необходимо поместить в коллекцию
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIter = list.listIterator(index);
        listIter.add(value);
    }

    /**
     * addAfter -  метод добавляет объект в коллекцию  после заданного индекса
     *
     * @param <T>   the type parameter
     * @param list  коллекция
     * @param index индекс, после   которого нужно разместить объект
     * @param value объект, который необходимо поместить в коллекцию
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIter = list.listIterator(index + 1);
        listIter.add(value);
    }

    /**
     * removeIf метод удаляет элементы  удовлетворяющие условию, указанному в предикате
     * @param <T>    the type parameter
     * @param list   коллекция элементов
     * @param filter предикат,  по которому определяют удаляемый объект
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
       ListIterator<T> listIter = list.listIterator();
       while (listIter.hasNext()) {
           T element = listIter.next();
          if (filter.test(element)) {
              listIter.remove();
          }
       }

    }

    /**
     * replaceIf метод заменяет объект удолетворяющий предикату на другой
     *
     * @param <T>    the type parameter
     * @param list   коллеция объектов типа Т
     * @param filter предикат
     * @param value  объект, который необходимо поместить на место удалённого
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> listIter = list.listIterator();
        while (listIter.hasNext()) {
            T element = listIter.next();
            if (filter.test(element)) {
                listIter.set(value);
            }
        }
    }

    /**
     * removeAll метод удаляет из  коллекции все элементы, которые помещены в другую коллекцию
     *
     * @param <T>      the type parameter
     * @param list     коллеция из  которой необходимо удалить элементы
     * @param elements коллекция элементов,  которые необходимо удалить.
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> listIter = elements.listIterator();
        while (listIter.hasNext()) {
            list.remove(listIter.next());
        }
    }
}
