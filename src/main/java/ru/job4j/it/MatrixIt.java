package ru.job4j.it;

import java.util.*;

/**
 * Класс - итератор для двухмерного массива int[][] который последовательно
 * возвращает все элементы.
 * С помощью переменных row и column двигаем указатель.
 */

    public class MatrixIt implements Iterator<Integer> {
        private final int[][] data;
        private int row = 0;
        private int column = 0;

        public MatrixIt(int[][] data) {
            this.data = data;
        }

        @Override
        public boolean hasNext() {
            while (row < data.length && data[row].length == column) {
                row++;
                column = 0;
            }
            return row < data.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[row][column++];
        }
    }


