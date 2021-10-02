package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Данный класс - Итератор, принимает список чисел и возвращает только четные цифры.
 * private int[] data - входящий список int для итератора
 * private int index -  выполняет функцию указателя
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private  int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    /**
     * Метод проверяет можно ли получить следующий элемент списка, соответствующий
     * заданному условию, а также присваивает значение индекса - указателю.
     * @return возвращает значение true если можно получить следующий элемент списка, соответствующий
     * заданному условию
     * возвращает false  если элемента нет или он не соответтствует условию.
     */
    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] % 2 != 0) {
            index++;
        }
        return index < data.length;
    }

    /**
     * Метод возвращает элемент списка по индексу указателя
     * и перемещает указатель увеличивая его значение на 1.
     *
     * Если следующего элемента, соответствующего заданному условию,
     * нет и при этом вызывается метод next,
     * то в этом случае итератор должен сгенерировать исключение NoSuchElementException()
     * @return возвращает элемент списка по индексу указателя.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

}