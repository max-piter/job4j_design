package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс BackwardArrayIt имплементирует Iterator<Integer>
 *
 * внутри реализован итератор для массива.
 * Итератор должен отдавать элементы в обратном порядке.
 * в конструкторе присвоил  значение int переменной point  -  конец массива,
 * в методе next() шагаю от неё,
 * пока не сравняюсь с 0 (что  прописано в методе hasNext(),
 * который контолирует диапазон итерации)
 *
 */


public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point;


    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
