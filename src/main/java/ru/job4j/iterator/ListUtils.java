package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * класс ListUtils -  является хранилищем методов ListIterator
 */
public class ListUtils {

    /**
     * Add before. метод  добавляет объект перед указанным индексом
     *
     * @param <T>   the type parameter
     * @param list  коллекция
     * @param index индекс, перед  которым нужно разместить объект
     * @param value объект, который необходимо поместить в коллекцию
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Add after -  метод добавляет объект в коллекцию  после заданного индекса
     *
     * @param <T>   the type parameter
     * @param list  коллекция
     * @param index индекс, после   которого нужно разместить объект
     * @param value объект, который необходимо поместить в коллекцию
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> l = list.listIterator();
        if (list.size() - 1 != index) {
        while (l.hasPrevious()) {
            if (l.previousIndex() == index) {
                l.add(value);
                break;
            }
            l.previous();
        }
        } else  {
            list.add(list.size(), value);
        }
    }

    /**
     * Remove if метод удаляет элементы  удовлетворяющие условию, указанному в предикате
     * @param <T>    the type parameter
     * @param list   коллекция элементов
     * @param filter предикат,  по которому определяют удаляемый объект
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
       ListIterator<T> l = list.listIterator();
       while (l.hasNext()) {
           T element = l.next();
          if (filter.test(element)) {
              l.remove();
          }
       }

    }

    /**
     * Replace if метод заменяет объект удолетворяющий предикату на другой
     *
     * @param <T>    the type parameter
     * @param list   коллеция объектов типа Т
     * @param filter предикат
     * @param value  объект, который необходимо поместить на место удалённого
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> l = list.listIterator();
        while (l.hasNext()) {
            T element = l.next();
            if (filter.test(element)) {
                l.set(value);
            }
        }
    }

    /**
     * Remove all метод удаляет из  коллекции все элементы, которые помещены в другую коллекцию
     *
     * @param <T>      the type parameter
     * @param list     коллеция из  которой необходимо удалить элементы
     * @param elements коллекция элементов,  которые необходимо удалить.
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> l = elements.listIterator();
        while (l.hasNext()) {
            list.remove(l.next());
        }
    }
}
