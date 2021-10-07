package ru.job4j.list;
import java.util.*;

/**
 * The type Simple array list.
 * Класс - реализация списка на основе динамического массива, аналог ArrayList
 * @param <T> the type parameter
 */
public class SimpleArrayList<T> implements List<T> {

    /**
     * массив с обобщённым типом элементов
     */
    private T[] container;

    /**
     * Счётчик длины листа, указывает на последний элемент Листа
     * !!! не путать с capacity - вместимостью
     */
    private int size;

    /**
     * Счётчик операций над Листом.
     */
    private int modCount;

    /**
     * конструктор принимает 1 параметр - первоначальную длину массива
     * устанавливает на ноль размер листа и счётчик операций
     * @param capacity - принимает в качестве параметра первоначальную длину массива
     */
    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
        this.size = 0;
        this.modCount = 0;
    }


    /**
     * метод  добавляет элемент в Лист
     * добавляем в первую свободную яцейку массива
     * если размер массива не позволяет добавить - увеличиваем размер массива в 2 раза
     * с помощью метода Arrays.copyOf();
     * @param value - элемент, который необходимо добавить
     */
    @Override
    public void add(T value) {
        if (size == container.length) {
           container = increaseArray(container);
        }
        container[size] = value;
        size++;
        modCount++;
    }

    /**
     * метод увеличивает массив в 2 раза
     * @param array - аргумент типа int, который мы сравниваем с длиной массива
     *
     */
    public T[] increaseArray(T[] array) {
        T[] conteiner = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            conteiner[i] = array[i];
        }
        array = conteiner;
        return array;
    }

    /**
     * замена значения по индексу
     * С помощью метода Objects.checkIndex(index, size); проверяется, что значение index
     * находится в пределах ранее добавленных в массив элементов.
     * @param index входной параметр
     * @param newValue - входной парметр, новое значение,
     *                 которое необходимо разместить по указанному индексу
     * @return возвращает старое значение!!!
     */
    @Override
    public T set(int index, T newValue) {
        int i = Objects.checkIndex(index, size);
        T oldValue = container[i];
        container[i] = newValue;
        return oldValue;
    }

    /**
     * удаление значения по индексу, при этом все остальные элементы
     * сдвигаются вправо с помощью метода System.arraycopy();
     * С помощью метода Objects.checkIndex(index, size); проверяется, что значение index
     *  находится в пределах ранее добавленных в массив элементов.
     * @param index -  входной параметр
     * @return возвращает старое значение
     */
    @Override
    public T remove(int index) {
        int i = Objects.checkIndex(index, size);
        T removedValue = container[i];

        System.arraycopy(container, i + 1,
                container, i,
                container.length - i - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;

        return removedValue;
    }

    /**
     * метод получения значения по индексу
     * С помощью метода Objects.checkIndex(index, size); проверяется, что значение index
     * находится в пределах ранее добавленных в массив элементов.
     * @param index - входной параметр
     * @return значение, соответствующее входному параметру индекса
     */
    @Override
    public T get(int index) {
        int i = Objects.checkIndex(index, size);
        return container[i];
    }

    /**
     *
     * @return возвращает длину Листа(именно занятые ячейки)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Итератор для объектов коллекции
     * @return  итератор
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            /**
             * счетчик операций над  Листом
             */
            private final int expectedModCount = modCount;

            /**
             * указатель итератора
             */
            private int point = 0;

            /**
             * проверка на наличе следующего элемента в диапазоне size
             *
             * @return true, если элемент есть и  false, если его нет
             */
            @Override
            public boolean hasNext() {
                return point < size;
            }

            /**
             * @return Возвращает элемент списка по индексу указателя
             * и перемещает указатель увеличивая его значение на +1.
             * @throws ConcurrentModificationException() - если с момента создания итератора,
             *                                           в коллекцию добавили новый элемент
             * @throws NoSuchElementException();         - если следующий элемент отсутствует
             */
            @Override
            public T next() {

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];

            }

        };
    }
}
